package uade.edu.guides.service.auth.strategies;

import org.springframework.stereotype.Component;

import uade.edu.guides.domain.AuthenticateUserDTO;
import uade.edu.guides.service.auth.IEstrategiaAutenticacion;

@Component
public class AutenticacionLocal implements IEstrategiaAutenticacion {

    @Override
    public void autenticarUsuario(AuthenticateUserDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'autenticarUsuario'");
    }

}
