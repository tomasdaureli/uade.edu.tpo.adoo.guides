package uade.edu.guides.service.auth;

import uade.edu.guides.domain.AuthenticateUserDTO;

public interface IEstrategiaAutenticacion {

    void autenticarUsuario(AuthenticateUserDTO dto);

}
