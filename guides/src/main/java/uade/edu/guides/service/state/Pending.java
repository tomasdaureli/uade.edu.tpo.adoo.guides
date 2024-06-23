package uade.edu.guides.service.state;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import uade.edu.guides.entity.Book;

@Slf4j
@Component("pendingStatus")
public class Pending implements IBookStatus {

    @Override
    public void sendTouristNotification(Book book) {
        log.info(String.format("Reserva de %s creada para %s.",
                book.getTrip().getService().getName(),
                book.getTourist().getUsername()));
    }

    @Override
    public void acceptBook(Book book) {
        book.setStatus("CONFIRMED");
    }

    @Override
    public void cancelBook(Book book) {
        book.setStatus("CANCELLED");
    }

    @Override
    public String getStatus() {
        return "PENDING";
    }

}
