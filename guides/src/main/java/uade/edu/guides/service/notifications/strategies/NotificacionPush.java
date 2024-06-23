package uade.edu.guides.service.notifications.strategies;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.NotificacionDTO;
import uade.edu.guides.service.notifications.IAdapterPushNotification;
import uade.edu.guides.service.notifications.IEstrategiaNotificacion;

@Component
@RequiredArgsConstructor
public class NotificacionPush implements IEstrategiaNotificacion {

    private final IAdapterPushNotification pushNotif;

    @Override
    public void enviarNotificacion(NotificacionDTO notificacion) {
        pushNotif.enviarNotificacion(notificacion);
    }

}
