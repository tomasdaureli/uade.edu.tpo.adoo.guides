package uade.edu.guides.service.state;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import uade.edu.guides.domain.NotificacionDTO;
import uade.edu.guides.entity.Book;
import uade.edu.guides.service.notifications.Notificador;

@Slf4j
@Component("cancelledStatus")
@RequiredArgsConstructor
public class Cancelled implements IBookStatus {

    private final Notificador notificador;

    @Override
    public void sendTouristNotification(Book book) {
        NotificacionDTO notif = new NotificacionDTO();
        notif.setReceptor(book.getTourist());
        notif.setDescripcion("Reserva Nº " + book.getId() + " cancelada.");
        notificador.enviarNotificacion(notif);
     
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
