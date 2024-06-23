package uade.edu.guides.service.auth;

import uade.edu.guides.domain.AuthenticateUserDTO;
import uade.edu.guides.domain.ProfileResponseDTO;

public interface IEstrategiaAutenticacion {

    void autenticarUsuario(ProfileResponseDTO dto);

}
