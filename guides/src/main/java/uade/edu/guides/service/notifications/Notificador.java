package uade.edu.guides.service.notifications;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.NotificacionDTO;

@Component
@RequiredArgsConstructor
public class Notificador {

    private IEstrategiaNotificacion notif;

    public void enviarNotificacion(NotificacionDTO notificacionDTO) {
        notif.enviarNotificacion(notificacionDTO);
    }

    public void cambiarEstrategiaNotif(IEstrategiaNotificacion estrategia) {
        this.notif = estrategia;
    }

}
