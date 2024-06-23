package uade.edu.guides.service.tourist;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import uade.edu.guides.entity.Book;

@Slf4j
@Component
public class Stripe implements IAdapterPago {

    @Override
    public void realizarPago(Book reserva) {
        log.info(String.format("Reserva Nº %s pagada con exito.", reserva.getId()));
    }

}
