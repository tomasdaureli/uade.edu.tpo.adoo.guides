package uade.edu.guides.service.auth;

import uade.edu.guides.domain.AuthenticateUserDTO;

public interface IAdapterAutenticacionExterna {

    Boolean autenticarUsuario(AuthenticateUserDTO dto);

}
