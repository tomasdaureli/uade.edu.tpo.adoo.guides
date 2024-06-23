package uade.edu.guides.service.state;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import uade.edu.guides.entity.Book;

@Slf4j
@Component("confirmedStatus")
public class Confirmed implements IBookStatus {

    @Override
    public void sendTouristNotification(Book book) {
        log.info(String.format("Reserva Nº %s confirmada.", book.getId()));
    }

    @Override
    public void acceptBook(Book book) {
        throw new IllegalStateException("La reserva ya fue confirmada.");
    }

    @Override
    public void cancelBook(Book book) {
        book.setStatus("CANCELLED");
    }

    @Override
    public String getStatus() {
        return "CONFIRMED";
    }

}
