package uade.edu.guides.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.*;
import uade.edu.guides.entity.Guide;
import uade.edu.guides.entity.Profile;
import uade.edu.guides.entity.Review;
import uade.edu.guides.mapper.ProfileMapper;
import uade.edu.guides.repository.ProfileRepository;
import uade.edu.guides.service.ProfileService;
import uade.edu.guides.service.auth.IEstrategiaAutenticacion;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository repository;
    private final ProfileMapper profileMapper;

    // lo inyectamos aca, o en la entidad, no me hace sentido que este en los dos
    // lugares
    private IEstrategiaAutenticacion estrategiaAutenticacion;

    @Override
    public List<ProfileResponseDTO> getAllProfiles() {
        List<Profile> listProfiles = repository.findAll();

        return listProfiles.stream()
                .map(profileMapper::toProfileResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProfileResponseDTO createUser(CreateProfileDTO dto) {
        Profile profile;

        if (ProfileTypeDTO.GUIDE.equals(dto.getType())) {
            profile = profileMapper.toGuide(dto);
        } else {
            profile = profileMapper.toTourist(dto);
        }

        Profile savedProfile = repository.save(profile);

        return profileMapper.toProfileResponseDTO(savedProfile);
    }

    @Override
    public ProfileResponseDTO getProfileByDNI(String dni) {
        Profile profile = repository.findByDni(dni)
                .orElseThrow(() -> new EntityNotFoundException("Perfil no encontrado para DNI: " + dni));

        return profileMapper.toProfileResponseDTO(profile);
    }

    @Override
    public ProfileResponseDTO updateProfile(Long profileId, UpdateProfileDTO dto) {
        Profile profile = repository.findById(profileId)
                .orElseThrow(() -> new EntityNotFoundException("Perfil no encontrado"));

        Profile savedProfile = repository.save(profileMapper.toProfileFromUpdateDTO(dto, profile));

        return profileMapper.toProfileResponseDTO(savedProfile);
    }

    @Override
    public boolean verifyCredential(String credentialId) {
        Random random = new Random();
        int randomNumber = random.nextInt(2);
        switch (randomNumber) {
            case 0:
                System.out.println("Credencial válida");
                return true;
            case 1:
                System.out.println("Credencial inválida");
                return false;
            default:
                throw new IllegalStateException("Número aleatorio fuera de rango");
        }
    }

    @Override
    public void addReview(Long guideId, ReviewDTO review) {
        // TODO: Implementacion buscando al guia en la base de datos y asociando la
        // review
    }

    @Override
    public void addTrophy(Long guideId, TrophyDTO trophy) {
        // TODO: Implementacion buscando al guia en la base de datos y asociando el
        // trofeo
    }

    @Override
    public List<TrophyDTO> getAllTrophies(Long guideId) {
        // TODO: Implementacion buscando al guia en la base de datos y obteniendo los
        // trofeos de ese guia en particular
        throw new UnsupportedOperationException("Unimplemented method 'getAllTrophies'");
    }

    @Override
    public boolean checkAvailability(Guide guide, Date startDate, Date endDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkAvailability'");
    }

    @Override
    public double calculateScore(List<Review> reviews) {

        if (reviews == null || reviews.isEmpty())
            return 0.0;

        double totalScore = 0.0;
        for (Review r : reviews) {
            totalScore += r.getScore();
        }

        return totalScore;
    }

    @Override
    public List<TripDTO> addTripToHistory(TripDTO trip) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addTripToHistory'");
    }

    @Override
    public void autenticarUsuario(AuthenticateUserDTO dto) {
        estrategiaAutenticacion.autenticarUsuario(dto);
    }

    @Override
    public void cambiarEstrategiaAutenticacion(IEstrategiaAutenticacion estrategia) {
        this.estrategiaAutenticacion = estrategia;
    }

}
