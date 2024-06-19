package uade.edu.guides.service.notifications.adapters;

import org.springframework.stereotype.Component;

import uade.edu.guides.domain.NotificacionDTO;
import uade.edu.guides.service.notifications.IAdapterMail;

@Component
public class JavaMail implements IAdapterMail {

    @Override
    public void enviarNotificacion(NotificacionDTO notificacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enviarNotificacion'");
    }

}
