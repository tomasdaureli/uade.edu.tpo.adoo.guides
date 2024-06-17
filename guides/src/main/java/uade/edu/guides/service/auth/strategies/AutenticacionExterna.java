package uade.edu.guides.service.auth.strategies;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.AuthenticateUserDTO;
import uade.edu.guides.service.auth.IAdapterAutenticacionExterna;
import uade.edu.guides.service.auth.IEstrategiaAutenticacion;

@Component
@RequiredArgsConstructor
public class AutenticacionExterna implements IEstrategiaAutenticacion {

    private IAdapterAutenticacionExterna autenticacionExterna;

    @Override
    public void autenticarUsuario(AuthenticateUserDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'autenticarUsuario'");
    }

}
