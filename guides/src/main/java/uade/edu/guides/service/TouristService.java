package uade.edu.guides.service;

import uade.edu.guides.domain.PaymentTypeDTO;
import uade.edu.guides.domain.ProfileResponseDTO;
import uade.edu.guides.entity.Tourist;

public interface TouristService {

    ProfileResponseDTO getTouristById(Long touristId);

    void realizarPago(Long touristId, Long bookId, PaymentTypeDTO pay);

    void increaseReviews(Tourist tourist);

}
