package uade.edu.guides.service.state;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.NotificacionDTO;
import uade.edu.guides.entity.Book;
import uade.edu.guides.service.notifications.Notificador;
import uade.edu.guides.service.notifications.adapters.JavaMail;
import uade.edu.guides.service.notifications.adapters.FireBase;
import uade.edu.guides.service.notifications.strategies.NotificacionMail;
import uade.edu.guides.service.notifications.strategies.NotificacionPush;

@Component("PENDING")
@RequiredArgsConstructor
public class Pending implements IBookStatus {

    private final Notificador notificador;

    @Override
    public void sendTouristNotification(Book book) {
        NotificacionDTO notif = new NotificacionDTO();
        notif.setReceptor(book.getTourist());
        notif.setDescripcion("Reserva de " + book.getTrip().getService().getName() + " creada para "
                + book.getTourist().getUsername());
        notificador.setNotif(new NotificacionMail(new JavaMail()));
        notificador.enviarNotificacion(notif);
        notificador.setNotif(new NotificacionPush(new FireBase()));
        notificador.enviarNotificacion(notif);
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
