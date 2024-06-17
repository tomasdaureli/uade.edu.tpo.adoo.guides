package uade.edu.guides.service.notifications.strategies;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.NotificacionDTO;
import uade.edu.guides.service.notifications.IEstrategiaNotificacion;

@Component
@RequiredArgsConstructor
public class NotificacionMail implements IEstrategiaNotificacion {

    @Override
    public void enviarNotificacion(NotificacionDTO notificacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enviarNotificacion'");
    }

}
