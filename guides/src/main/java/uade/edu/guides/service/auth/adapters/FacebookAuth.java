package uade.edu.guides.service.auth.adapters;

import java.util.Random;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import uade.edu.guides.domain.AuthenticateUserDTO;
import uade.edu.guides.service.auth.IAdapterAutenticacionExterna;

@Slf4j
@Component("facebookAdapter")
public class FacebookAuth implements IAdapterAutenticacionExterna {

    @Override
    public Boolean autenticarUsuario(AuthenticateUserDTO dto) {
        Random random = new Random();
        int randomNumber = random.nextInt(2);
        switch (randomNumber) {
            case 0:
                log.info("Autenticado con Facebook");
                return true;
            case 1:
                return false;
            default:
                throw new IllegalStateException("Número aleatorio fuera de rango");
        }
    }

}
