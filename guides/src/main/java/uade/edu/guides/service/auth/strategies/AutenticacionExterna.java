package uade.edu.guides.service.auth.strategies;

import java.util.Random;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.AuthenticateUserDTO;
import uade.edu.guides.service.auth.IAdapterAutenticacionExterna;
import uade.edu.guides.service.auth.IEstrategiaAutenticacion;

@Component("autenticacionExterna")
@RequiredArgsConstructor
public class AutenticacionExterna implements IEstrategiaAutenticacion {

    private final IAdapterAutenticacionExterna appleAdapter;
    private final IAdapterAutenticacionExterna facebookAdapter;
    private final IAdapterAutenticacionExterna googleAdapter;

    @Override
    public Boolean autenticarUsuario(AuthenticateUserDTO dto) {
        Random random = new Random();
        int randomNumber = random.nextInt(2);
        switch (randomNumber) {
            case 0:
                return appleAdapter.autenticarUsuario(dto);
            case 1:
                return facebookAdapter.autenticarUsuario(dto);
            default:
                return googleAdapter.autenticarUsuario(dto);
        }
    }

    @Override
    public String getAutenticacion() {
        return "EXTERNAL";
    }

}
