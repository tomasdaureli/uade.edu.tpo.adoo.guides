package uade.edu.guides.service.notifications;

import uade.edu.guides.domain.NotificacionDTO;

public interface IAdapterMail {

    void enviarNotificacion(NotificacionDTO notificacion);

}
