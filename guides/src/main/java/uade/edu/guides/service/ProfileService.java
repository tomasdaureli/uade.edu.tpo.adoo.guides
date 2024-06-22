package uade.edu.guides.service;

import java.util.List;
import java.util.Date;

import uade.edu.guides.domain.*;
import uade.edu.guides.entity.Guide;
import uade.edu.guides.service.auth.IEstrategiaAutenticacion;

public interface ProfileService {

    List<ProfileResponseDTO> getAllProfiles();

    ProfileResponseDTO createUser(CreateProfileDTO dto);

    ProfileResponseDTO updateProfile(Long profileId, UpdateProfileDTO dto);

    // haria este metodo privado y pasa a GuideService (Pensar como va a ser la
    // relacion con la reserva)
    Boolean checkAvailability(Guide guide, Date startDate, Date endDate);

    void autenticarUsuario(AuthenticateUserDTO dto);

    void cambiarEstrategiaAutenticacion(IEstrategiaAutenticacion estrategia);

}
