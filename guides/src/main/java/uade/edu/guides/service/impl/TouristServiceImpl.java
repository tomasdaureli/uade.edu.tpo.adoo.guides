package uade.edu.guides.service.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.ProfileResponseDTO;
import uade.edu.guides.entity.Book;
import uade.edu.guides.entity.Tourist;
import uade.edu.guides.exception.BookNotFoundException;
import uade.edu.guides.exception.ProfileNotFoundException;
import uade.edu.guides.mapper.ProfileMapper;
import uade.edu.guides.repository.BookRepository;
import uade.edu.guides.repository.ProfileRepository;
import uade.edu.guides.service.TouristService;
import uade.edu.guides.service.tourist.IAdapterPago;

@Service
@RequiredArgsConstructor
public class TouristServiceImpl implements TouristService {

    private final ProfileRepository profileRepository;

    private final BookRepository bookRepository;

    private final ProfileMapper mapper;

    private final IAdapterPago pago;

    @Override
    public ProfileResponseDTO getTouristById(Long touristId) {
        Tourist tourist = profileRepository.findTouristById(touristId)
                .orElseThrow(ProfileNotFoundException::new);

        return mapper.toProfileResponseDTO(tourist);
    }

    @Override
    public void realizarPago(Long touristId, Long bookId) {
        Tourist tourist = profileRepository.findTouristById(touristId)
                .orElseThrow(ProfileNotFoundException::new);

        Book book = bookRepository.findById(bookId)
                .orElseThrow(BookNotFoundException::new);

        if (book.getTourist().equals(tourist)) {
            pago.realizarPago(book);
        }
    }

}
