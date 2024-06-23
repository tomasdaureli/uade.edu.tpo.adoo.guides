package uade.edu.guides.service.auth.strategies;

import java.util.Random;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.ProfileResponseDTO;
import uade.edu.guides.service.auth.IAdapterAutenticacionExterna;
import uade.edu.guides.service.auth.IEstrategiaAutenticacion;

@Component
@RequiredArgsConstructor
public class AutenticacionExterna implements IEstrategiaAutenticacion {

    private IAdapterAutenticacionExterna autenticacionExterna;

    @Override
    public void autenticarUsuario(ProfileResponseDTO dto) {
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
