package uade.edu.guides.service.auth;

import uade.edu.guides.domain.AuthenticateUserDTO;

public interface IAdapterAutenticacionExterna {

    void autenticarUsuario(AuthenticateUserDTO dto);

}
