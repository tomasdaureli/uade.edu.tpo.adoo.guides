package uade.edu.guides.service.notifications.strategies;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.NotificacionDTO;
import uade.edu.guides.service.notifications.IEstrategiaNotificacion;
import uade.edu.guides.service.notifications.adapters.JavaMail;

@Component
@RequiredArgsConstructor
public class NotificacionMail implements IEstrategiaNotificacion {

    private final JavaMail javaMail;

    @Override
    public void enviarNotificacion(NotificacionDTO notificacion) {
        javaMail.enviarNotificacion(notificacion);
    }

}
