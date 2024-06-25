package uade.edu.guides.service;

import uade.edu.guides.domain.PaymentTypeDTO;
import uade.edu.guides.domain.ProfileResponseDTO;

public interface TouristService {

    ProfileResponseDTO getTouristById(Long touristId);

    void realizarPago(Long touristId, Long bookId, PaymentTypeDTO pay);

}
