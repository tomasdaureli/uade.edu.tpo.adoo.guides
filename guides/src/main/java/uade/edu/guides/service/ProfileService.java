package uade.edu.guides.service;

import java.util.List;

import uade.edu.guides.domain.*;
import uade.edu.guides.service.auth.IEstrategiaAutenticacion;

public interface ProfileService {

    List<ProfileResponseDTO> getAllProfiles();

    ProfileResponseDTO createUser(CreateProfileDTO dto);

    ProfileResponseDTO updateProfile(Long profileId, UpdateProfileDTO dto);

    void autenticarUsuario(AuthenticateUserDTO dto);

    void cambiarEstrategiaAutenticacion(IEstrategiaAutenticacion estrategia);

}
