package uade.edu.guides.service.tourist;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import uade.edu.guides.domain.PaymentTypeDTO;

@Slf4j
@Component
public class Stripe implements IAdapterPago {

    @Override
    public void realizarPago(Long bookId, Double payAmount, PaymentTypeDTO pay) {
        if (PaymentTypeDTO.SIGN.equals(pay)) {
            log.info(String.format("Se pago la seña de la reserva Nº %s por un valor de %s", bookId, payAmount));
        } else {
            log.info(String.format("Se pago el total restante de la reserva Nº %s por el valor de %s",
                    bookId, payAmount));
        }

    }

}
