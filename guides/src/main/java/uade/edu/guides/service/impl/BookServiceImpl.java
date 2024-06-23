package uade.edu.guides.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.*;
import uade.edu.guides.entity.*;
import uade.edu.guides.exception.*;
import uade.edu.guides.mapper.BookMapper;
import uade.edu.guides.repository.*;
import uade.edu.guides.service.*;
import uade.edu.guides.service.notifications.Notificador;
import uade.edu.guides.service.notifications.adapters.FireBase;
import uade.edu.guides.service.notifications.adapters.JavaMail;
import uade.edu.guides.service.notifications.strategies.NotificacionMail;
import uade.edu.guides.service.notifications.strategies.NotificacionPush;
import uade.edu.guides.service.state.*;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    private final BookMapper mapper;

    private final FacturaService facturaService;

    private final ProfileRepository profileRepository;

    private final TourismServiceRepository serviceRepository;

    private final TripRepository tripRepository;

    private final IBookStatus pendingStatus;
    private final IBookStatus confirmedStatus;
    private final IBookStatus cancelledStatus;

    private final Notificador notificador;
    private static final Double SIGN_PERCENT = 0.10;
    private static final Double RECHARGE = 0.5; // 50%
    private static final Long DAYS_TO_REVIEW = 3L;

    @Override
    public void changeStatus(Book book, IBookStatus status) {
        sendTouristNotification(book, status);
        book.setStatus(status.getStatus());
    }

    @Override
    public BookDTO createBook(CreateBookDTO dto) {
        Tourist tourist = profileRepository.findTouristById(dto.getTouristId())
                .orElseThrow(ProfileNotFoundException::new);

        Trip newTrip = buildTrip(dto);

        if (newTrip != null) {
            Book newBook = new Book();

            newBook.setTrip(newTrip);
            newBook.setTourist(tourist);
            newBook.setSignPayment(calculateSign(newTrip));
            changeStatus(newBook, pendingStatus);
            sendGuideNotification(repository.save(newBook));
            facturaService.createFactura(newBook, tourist);

            return mapper.toBookDTO(newBook);
        }

        throw new IllegalStateException("Se produjo un error al crear la reserva.");
    }

    private Double calculateSign(Trip trip) {
        return trip.getService().getPrice() * SIGN_PERCENT;
    }

    private Trip buildTrip(CreateBookDTO dto) {
        Guide guide = profileRepository.findGuideById(dto.getGuideId())
                .orElseThrow(GuideNotFoundException::new);

        TourismService service = serviceRepository.findById(dto.getServiceId())
                .orElseThrow(TourismServiceNotFoundException::new);

        if (guideHasService(guide, service)
                && checkAvailability(guide, dto.getStartDate(), dto.getEndDate())) {
            Trip trip = new Trip();
            trip.setStartDate(dto.getStartDate());
            trip.setEndDate(dto.getEndDate());
            trip.setGuide(guide);
            trip.setService(service);
            return tripRepository.save(trip);
        }

        return null;
    }

    private Boolean guideHasService(Guide guide, TourismService service) {
        List<TourismService> guideServices = guide.getServices();
        return guideServices.contains(service);
    }

    private Boolean checkAvailability(Guide guide, LocalDate startDate, LocalDate endDate) {
        List<Trip> guideTrips = tripRepository.findByGuide(guide);

        for (Trip trip : guideTrips) {
            if (isTripOverlap(trip, startDate, endDate)) {
                return false;
            }
        }

        return true;
    }

    private boolean isTripOverlap(Trip trip, LocalDate startDate, LocalDate endDate) {
        LocalDate tripStartDate = trip.getStartDate();
        LocalDate tripEndDate = trip.getEndDate();

        return !(endDate.isBefore(tripStartDate) || startDate.isAfter(tripEndDate));
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return repository.findAll().stream()
                .map(mapper::toBookDTO)
                .toList();
    }

    @Override
    public BookDTO getBookById(Long id) {
        Book book = repository.findById(id)
                .orElseThrow(BookNotFoundException::new);

        return mapper.toBookDTO(book);
    }

    @Override
    public void acceptBook(Long id) {
        Book book = repository.findById(id)
                .orElseThrow(BookNotFoundException::new);

        changeStatus(book, confirmedStatus);

        repository.save(book);
    }

    @Override
    public void cancelBook(Long id, Long profileId) {
        Book book = repository.findById(id)
                .orElseThrow(BookNotFoundException::new);

        if (Boolean.TRUE.equals(touristCancell(profileId))) {
            facturaService.updateFactura(book, addRecharge(book));
        }
        changeStatus(book, cancelledStatus);

        repository.save(book);
    }

    private Boolean touristCancell(Long profileId) {
        Profile profile = profileRepository.findProfileByID(profileId);
        return profile instanceof Tourist;
    }

    private Double addRecharge(Book book) {
        Double amountRecharge = 0.0;

        if (LocalDate.now().isEqual(book.getTrip().getStartDate())
                || LocalDate.now().isAfter(book.getTrip().getStartDate())) {
            amountRecharge = 1.0;
        }
        if (book.getStatus().equals("CONFIRMED")) {
            amountRecharge = RECHARGE;
        }

        return amountRecharge;
    }

    @Override
    public List<BookDTO> getBooksByTourist(Long touristId) {
        Tourist tourist = profileRepository.findTouristById(touristId)
                .orElseThrow(ProfileNotFoundException::new);

        List<Book> books = repository.findByTourist(tourist);

        if (!books.isEmpty()) {
            return books.stream()
                    .map(mapper::toBookDTO)
                    .toList();
        }

        return new ArrayList<>();
    }

    private void sendGuideNotification(Book book) {
        NotificacionDTO notif = new NotificacionDTO();
        notif.setReceptor(book.getTrip().getGuide());
        notif.setDescripcion(
                "Se creo una Reseva " + book.getId() + " por el turista " + book.getTourist().getUsername());
        notificador.setNotif(new NotificacionMail(new JavaMail()));
        notificador.enviarNotificacion(notif);
        notificador.setNotif(new NotificacionPush(new FireBase()));
        notificador.enviarNotificacion(notif);

    }

    @Override
    public void sendTouristNotification(Book book, IBookStatus status) {
        status.sendTouristNotification(book);
    }

    @Scheduled(cron = "0 0 10 * * ?")
    private void sendTouristNotificationAfterEndDate() {
        LocalDate currentDate = LocalDate.now();
        List<Book> endedBooks = repository.findByTripEndDateBefore(currentDate);
        for (Book b : endedBooks) {
            if (currentDate.minusDays(DAYS_TO_REVIEW).isEqual(b.getTrip().getEndDate())) {
                NotificacionDTO notif = new NotificacionDTO();
                notif.setReceptor(b.getTourist());
                notif.setDescripcion("Califique al Guia " + b.getTrip().getGuide().getName() + " "
                        + b.getTrip().getGuide().getLastName() + "\nPor el Servicio : "
                        + b.getTrip().getService().getName());
                notificador.cambiarEstrategiaNotif(new NotificacionMail(new JavaMail()));
                notificador.enviarNotificacion(notif);
                notificador.cambiarEstrategiaNotif(new NotificacionPush(new FireBase()));
                notificador.enviarNotificacion(notif);
            }

        }

    }

}
