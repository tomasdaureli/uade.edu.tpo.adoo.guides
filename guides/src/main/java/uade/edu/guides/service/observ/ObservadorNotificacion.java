package uade.edu.guides.service.observ;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.NotificacionDTO;
import uade.edu.guides.domain.TrophyDTO;
import uade.edu.guides.repository.ProfileRepository;
import uade.edu.guides.service.notifications.Notificador;
import uade.edu.guides.service.notifications.adapters.FireBase;
import uade.edu.guides.service.notifications.adapters.JavaMail;
import uade.edu.guides.service.notifications.strategies.NotificacionMail;
import uade.edu.guides.service.notifications.strategies.NotificacionPush;

@Component
@RequiredArgsConstructor
public class ObservadorNotificacion implements IObserver {

    private final Notificador notificador;
    private final ProfileRepository repository;

    @Override
    public void addTrophyGuide(Long guideId, TrophyDTO trophyDto) {
        NotificacionDTO dtoNotif = new NotificacionDTO();
        dtoNotif.setReceptor(repository.findProfileByID(guideId));
        dtoNotif.setDescripcion("Nuevo trofeo Obtenido. Felicitaciones! " + dtoNotif.getReceptor().getName() + " "
                + dtoNotif.getReceptor().getLastName());
        notificador.setNotif(new NotificacionMail(new JavaMail()));
        notificador.enviarNotificacion(dtoNotif);
        notificador.setNotif(new NotificacionPush(new FireBase()));
        notificador.enviarNotificacion(dtoNotif);

    }

}