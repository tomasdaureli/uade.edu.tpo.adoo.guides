package uade.edu.guides.service.auth.strategies;

import java.util.Random;

import org.springframework.stereotype.Component;

import uade.edu.guides.domain.AuthenticateUserDTO;
import uade.edu.guides.service.auth.IEstrategiaAutenticacion;

@Component("INTERNAL")
public class AutenticacionLocal implements IEstrategiaAutenticacion {

    @Override
    public Boolean autenticarUsuario(AuthenticateUserDTO dto) {
        Random random = new Random();
        int randomNumber = random.nextInt(2);
        switch (randomNumber) {
            case 0:
                return true;
            case 1:
                return false;
            default:
                throw new IllegalStateException("Número aleatorio fuera de rango");
        }
    }

    @Override
    public String getAutenticacion() {
        return "INTERNAL";
    }

}
