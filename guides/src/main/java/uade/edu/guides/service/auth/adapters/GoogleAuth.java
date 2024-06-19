package uade.edu.guides.service.auth.adapters;

import org.springframework.stereotype.Component;

import uade.edu.guides.domain.AuthenticateUserDTO;
import uade.edu.guides.service.auth.IAdapterAutenticacionExterna;

@Component
public class GoogleAuth implements IAdapterAutenticacionExterna {

    @Override
    public void autenticarUsuario(AuthenticateUserDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'autenticarUsuario'");
    }

}
