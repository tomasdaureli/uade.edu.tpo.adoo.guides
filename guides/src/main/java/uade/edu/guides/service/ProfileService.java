package uade.edu.guides.service;

import java.util.List;
import java.util.Date;

import uade.edu.guides.domain.*;
import uade.edu.guides.entity.Guide;
import uade.edu.guides.entity.Review;
import uade.edu.guides.entity.Trip;
import uade.edu.guides.entity.Trophy;
import uade.edu.guides.service.auth.IEstrategiaAutenticacion;


public interface ProfileService {

    List<ProfileResponseDTO> getAllProfiles();

    ProfileResponseDTO createUser(CreateProfileDTO dto);

    ProfileResponseDTO getProfileByDNI(String DNI);

    ProfileResponseDTO updateProfile(UpdateProfileDTO dto);

    boolean verifyCredential(String credentialId);

    void addReview(Guide guide,Review review);

    void addTrophy(Guide guide, Trophy trophy);

    List<Trophy> getAllTrophies(Guide guide);

    boolean checkAvailability(Guide guide, Date startDate, Date endDate);

    double calculateScore(List<Review> reviews);

    List<TripDTO> addTripToHistory(TripDTO trip);

    void autenticarUsuario(AuthenticateUserDTO dto);

    void cambiarEstrategiaAutenticacion(IEstrategiaAutenticacion estrategia);

}
