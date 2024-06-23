package uade.edu.guides.service.state;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.NotificacionDTO;
import uade.edu.guides.entity.Book;
import uade.edu.guides.service.notifications.Notificador;
import uade.edu.guides.service.notifications.adapters.FireBase;
import uade.edu.guides.service.notifications.adapters.JavaMail;
import uade.edu.guides.service.notifications.strategies.NotificacionMail;
import uade.edu.guides.service.notifications.strategies.NotificacionPush;

@Component("cancelledStatus")
@RequiredArgsConstructor
public class Cancelled implements IBookStatus {

    private final Notificador notificador;

    @Override
    public void sendTouristNotification(Book book) {
        NotificacionDTO notif = new NotificacionDTO();
        notif.setReceptor(book.getTourist());
        notif.setDescripcion("Reserva Nº " + book.getId() + " cancelada.");
        notificador.setNotif(new NotificacionMail(new JavaMail()));
        notificador.enviarNotificacion(notif);
        notificador.setNotif(new NotificacionPush(new FireBase()));
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
