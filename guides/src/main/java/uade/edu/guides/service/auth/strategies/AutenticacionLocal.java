package uade.edu.guides.service.auth.strategies;

import java.util.Random;

import org.springframework.stereotype.Component;

import uade.edu.guides.domain.AuthenticateUserDTO;
import uade.edu.guides.service.auth.IEstrategiaAutenticacion;

@Component
public class AutenticacionLocal implements IEstrategiaAutenticacion {

    @Override
    public void autenticarUsuario(AuthenticateUserDTO dto) {
        System.out.println("Autenticacion Externa: ");
        Random random = new Random();
        int randomNumber = random.nextInt(2); 
        switch (randomNumber) {
            case 0:
                System.out.println("Autenticacion Completada!");
            case 1:
                System.out.println("Error en la Autenticacion");
            default:
                throw new IllegalStateException("Número aleatorio fuera de rango");
        }
    }

}
