package uade.edu.guides.service.notifications.strategies;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.NotificacionDTO;
import uade.edu.guides.service.notifications.IEstrategiaNotificacion;
import uade.edu.guides.service.notifications.adapters.FireBase;

@Component
@RequiredArgsConstructor
public class NotificacionPush implements IEstrategiaNotificacion {

    private final FireBase fireBase;

    @Override
    public void enviarNotificacion(NotificacionDTO notificacion) {
        fireBase.enviarNotificacion(notificacion);
    }

}
