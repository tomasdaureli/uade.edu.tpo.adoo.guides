package uade.edu.guides.service;

import java.util.List;
import java.util.Date;

import uade.edu.guides.domain.*;
import uade.edu.guides.entity.Guide;
import uade.edu.guides.entity.Review;
import uade.edu.guides.service.auth.IEstrategiaAutenticacion;

public interface ProfileService {

    List<ProfileResponseDTO> getAllProfiles();

    ProfileResponseDTO createUser(CreateProfileDTO dto);

    ProfileResponseDTO getProfileByDNI(String dni);

    ProfileResponseDTO updateProfile(Long profileId, UpdateProfileDTO dto);

    boolean verifyCredential(String credentialId);

    void addReview(Long guideId, ReviewDTO review);

    void addTrophy(Long guideId, TrophyDTO trophy);

    List<TrophyDTO> getAllTrophies(Long guideId);

    // haria este metodo privado
    boolean checkAvailability(Guide guide, Date startDate, Date endDate);

    // haria este metodo privado
    double calculateScore(List<Review> reviews);

    // haria este metodo privado o lo eliminaria directamente, pq se va a asociar
    // directamente en la BD
    List<TripDTO> addTripToHistory(TripDTO trip);

    void autenticarUsuario(AuthenticateUserDTO dto);

    void cambiarEstrategiaAutenticacion(IEstrategiaAutenticacion estrategia);

}
