package uade.edu.guides.service.notifications.adapters;

import org.springframework.stereotype.Component;

import uade.edu.guides.domain.NotificacionDTO;
import uade.edu.guides.service.notifications.IAdapterPushNotification;

@Component
public class FireBase implements IAdapterPushNotification {

    @Override
    public void enviarNotificacion(NotificacionDTO notificacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enviarNotificacion'");
    }

}
