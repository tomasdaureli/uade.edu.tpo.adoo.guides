package uade.edu.guides.service.state;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import uade.edu.guides.entity.Book;

@Slf4j
@Component("cancelledStatus")
public class Cancelled implements IBookStatus {

    @Override
    public void sendTouristNotification(Book book) {
        log.info(String.format("Reserva Nº %s cancelada.", book.getId()));
    }

    @Override
    public void acceptBook(Book book) {
        throw new IllegalStateException("La reserva ya fue cancelada.");
    }

    @Override
    public void cancelBook(Book book) {
        throw new IllegalStateException("La reserva ya fue cancelada.");
    }

    @Override
    public String getStatus() {
        return "CANCELLED";
    }

}
