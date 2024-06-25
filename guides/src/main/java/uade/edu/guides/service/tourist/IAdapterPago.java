package uade.edu.guides.service.tourist;

import uade.edu.guides.domain.PaymentTypeDTO;

public interface IAdapterPago {

    void realizarPago(Long bookId, Double payAmount, PaymentTypeDTO pay);

}
