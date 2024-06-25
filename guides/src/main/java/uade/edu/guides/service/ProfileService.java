package uade.edu.guides.service;

import java.util.List;

import uade.edu.guides.domain.*;
import uade.edu.guides.entity.Profile;
import uade.edu.guides.service.auth.IEstrategiaAutenticacion;
import uade.edu.guides.service.observ.IObserver;

public interface ProfileService {

    List<ProfileResponseDTO> getAllProfiles();

    ProfileResponseDTO createUser(CreateProfileDTO dto);

    ProfileResponseDTO updateProfile(Long profileId, UpdateProfileDTO dto);

    ProfileResponseDTO autenticarUsuario(AuthenticateUserDTO authDto);

    void cambiarEstrategiaAutenticacion(Long profileId, IEstrategiaAutenticacion estrategia);

    void createReview(Long guideId, ReviewDTO review, Long touristId);

    void addTrophy(Profile profile, TrophyDTO trophy);

    void attach(IObserver observer);

    void detach(IObserver observer);

    List<TrophyDTO> getAllTrophies(Long profileId);

}
