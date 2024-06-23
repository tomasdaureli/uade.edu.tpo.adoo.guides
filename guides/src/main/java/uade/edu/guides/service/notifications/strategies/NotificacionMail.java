package uade.edu.guides.service.notifications.strategies;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.NotificacionDTO;
import uade.edu.guides.service.notifications.IAdapterMail;
import uade.edu.guides.service.notifications.IEstrategiaNotificacion;

@Component
@RequiredArgsConstructor
public class NotificacionMail implements IEstrategiaNotificacion {
    
    private final IAdapterMail adapterMail;

    @Override
    public void enviarNotificacion(NotificacionDTO notificacion) {
        adapterMail.enviarNotificacion(notificacion);
    }

}
