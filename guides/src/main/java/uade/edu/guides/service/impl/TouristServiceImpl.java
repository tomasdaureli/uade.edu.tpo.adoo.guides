package uade.edu.guides.service.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.PaymentTypeDTO;
import uade.edu.guides.domain.ProfileResponseDTO;
import uade.edu.guides.entity.Book;
import uade.edu.guides.entity.Factura;
import uade.edu.guides.entity.Tourist;
import uade.edu.guides.exception.BookNotFoundException;
import uade.edu.guides.exception.FacturaNotFoundException;
import uade.edu.guides.exception.ProfileNotFoundException;
import uade.edu.guides.mapper.ProfileMapper;
import uade.edu.guides.repository.BookRepository;
import uade.edu.guides.repository.FacturaRepository;
import uade.edu.guides.repository.ProfileRepository;
import uade.edu.guides.service.TouristService;
import uade.edu.guides.service.tourist.IAdapterPago;

@Service
@RequiredArgsConstructor
public class TouristServiceImpl implements TouristService {

    private final ProfileRepository profileRepository;

    private final BookRepository bookRepository;

    private final FacturaRepository facturaRepository;

    private final ProfileMapper mapper;

    private final IAdapterPago pago;

    @Override
    public ProfileResponseDTO getTouristById(Long touristId) {
        Tourist tourist = profileRepository.findTouristById(touristId)
                .orElseThrow(ProfileNotFoundException::new);

        return mapper.toProfileResponseDTO(tourist);
    }

    @Override
    public void realizarPago(Long touristId, Long bookId, PaymentTypeDTO pay) {
        Tourist tourist = profileRepository.findTouristById(touristId)
                .orElseThrow(ProfileNotFoundException::new);

        Book book = bookRepository.findById(bookId)
                .orElseThrow(BookNotFoundException::new);

        if (book.getTourist().equals(tourist)) {
            if (PaymentTypeDTO.SIGN.equals(pay)) {
                pago.realizarPago(book.getId(), book.getSignPayment(), pay);
            } else {
                Factura factura = facturaRepository.findByReserva(book)
                        .orElseThrow(FacturaNotFoundException::new);
                pago.realizarPago(book.getId(), factura.getPendiente(), pay);
            }
        }
    }

}
