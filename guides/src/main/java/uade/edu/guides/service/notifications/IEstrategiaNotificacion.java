package uade.edu.guides.service.notifications;

import uade.edu.guides.domain.NotificacionDTO;

public interface IEstrategiaNotificacion {

    void enviarNotificacion(NotificacionDTO notificacion);

}
