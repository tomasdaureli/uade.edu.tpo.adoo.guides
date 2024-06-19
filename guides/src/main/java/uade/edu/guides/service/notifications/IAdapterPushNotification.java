package uade.edu.guides.service.notifications;

import uade.edu.guides.domain.NotificacionDTO;

public interface IAdapterPushNotification {

    void enviarNotificacion(NotificacionDTO notificacion);

}
