package uade.edu.guides.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.*;
import uade.edu.guides.entity.*;
import uade.edu.guides.exception.*;
import uade.edu.guides.mapper.BookMapper;
import uade.edu.guides.repository.*;
import uade.edu.guides.service.*;
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

    @Override
    public void changeStatus(Book book, IBookStatus status) {
        status.sendTouristNotification(book);
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
            changeStatus(newBook, pendingStatus);

            return mapper.toBookDTO(repository.save(newBook));
        }

        throw new IllegalStateException("Se produjo un error al crear la reserva.");
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
    public void cancelBook(Long id) {
        Book book = repository.findById(id)
                .orElseThrow(BookNotFoundException::new);

        changeStatus(book, cancelledStatus);

        repository.save(book);
    }

    @Override
    public void sendGuideNotification(Book book) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendGuideNotification'");
    }

    @Override
    public void sendTouristNotification(Book book) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendTouristNotification'");
    }

    @Override
    public FacturaDTO getFacturaByBookId(Long bookId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFacturaByBookId'");
    }

}
