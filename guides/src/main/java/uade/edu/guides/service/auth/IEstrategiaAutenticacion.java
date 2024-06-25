package uade.edu.guides.service.auth;

import uade.edu.guides.domain.AuthenticateUserDTO;

public interface IEstrategiaAutenticacion {

    Boolean autenticarUsuario(AuthenticateUserDTO dto);

    String getAutenticacion();

}
