package uade.edu.guides.service.state;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.NotificacionDTO;
import uade.edu.guides.entity.Book;
import uade.edu.guides.service.notifications.Notificador;

@Component("confirmedStatus")
@RequiredArgsConstructor
public class Confirmed implements IBookStatus {

    private final Notificador notificador;

    @Override
    public void sendTouristNotification(Book book) {
        NotificacionDTO notif = new NotificacionDTO();
        notif.setReceptor(book.getTourist());
        notif.setDescripcion("Reserva Nº " + book.getId() + " confirmada.");
        notificador.enviarNotificacion(notif);
     
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
