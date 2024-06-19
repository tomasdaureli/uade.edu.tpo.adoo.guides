package uade.edu.guides.service.notifications;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.NotificacionDTO;

@Component
@RequiredArgsConstructor
public abstract class Notificador {

    private final IEstrategiaNotificacion notif;

    public void enviarNotificacion(NotificacionDTO notificacionDTO) {
    }

    public void cambiarEstrategiaNotif(IEstrategiaNotificacion estrategia) {
    }

}
