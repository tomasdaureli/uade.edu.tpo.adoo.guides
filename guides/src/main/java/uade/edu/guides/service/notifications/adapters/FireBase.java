package uade.edu.guides.service.notifications.adapters;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import uade.edu.guides.domain.NotificacionDTO;
import uade.edu.guides.service.notifications.IAdapterPushNotification;

@Component
@Slf4j
public class FireBase implements IAdapterPushNotification {

    @Override
    public void enviarNotificacion(NotificacionDTO notificacion) {
        log.info("Se envio una notificacion a " + notificacion.getReceptor().getName() + " "
                + notificacion.getReceptor().getLastName() + "\n Asunto: " + notificacion.getDescripcion()
                + "\nNotificacion enviada via FireBase");
    }

}
