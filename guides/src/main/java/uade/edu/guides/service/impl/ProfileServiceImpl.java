package uade.edu.guides.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.*;
import uade.edu.guides.entity.Book;
import uade.edu.guides.entity.Guide;
import uade.edu.guides.entity.Profile;
import uade.edu.guides.entity.Review;
import uade.edu.guides.entity.Trophy;
import uade.edu.guides.mapper.ProfileMapper;
import uade.edu.guides.repository.BookRepository;
import uade.edu.guides.repository.ProfileRepository;
import uade.edu.guides.service.ProfileService;
import uade.edu.guides.service.auth.IEstrategiaAutenticacion;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository repository;
    private final BookRepository bookRepository;
    private final ProfileMapper profileMapper;
    private static long count = 0;
    private IEstrategiaAutenticacion estrategiaAutenticacion;

    @Override
    public List<ProfileResponseDTO> getAllProfiles() {    
        List<Profile> listProfiles = repository.findAll();

        return listProfiles.stream()
        .map(profile -> {
            ProfileResponseDTO profileResponseDTO = new ProfileResponseDTO();
            profileResponseDTO.setId(profile.getId());
            profileResponseDTO.setName(profile.getName());
            profileResponseDTO.setLastName(profile.getLastName());
            profileResponseDTO.setDni(profile.getDni());
            profileResponseDTO.setEmail(profile.getEmail());
            profileResponseDTO.setPhoneNumber(profile.getPhoneNumber());
            profileResponseDTO.setUser(profile.getUser());
            profileResponseDTO.setGender(profileMapper.toGenderFromGenderDTO(profile.getGender()));
            profileResponseDTO.setHistoryTrips(profileMapper.toListTripDTOFromListTrip(profile.getHistoryTrips()));

            return profileResponseDTO;
        })
        .collect(Collectors.toList());
}

    @Override
    public ProfileResponseDTO createUser(CreateProfileDTO dto) {

        ProfileResponseDTO newProfile = new ProfileResponseDTO(count, dto.getName(), dto.getLastName(), dto.getGender(), dto.getDni(), dto.getEmail(), dto.getPhoneNumber(), dto.getUser(), dto.getPassword(),null);

        Profile profile = profileMapper.toProfileEntity(profileMapper.toProfileResponseFromCreateProfileDTO(newProfile));

        Profile savedProfile = repository.save(profile);

        return profileMapper.toProfileResponseDTO(savedProfile);

    }

    @Override
    public ProfileResponseDTO getProfileByDNI(String dni) {
        List<Profile> listProfiles = repository.findAll();
        
        for (Profile p : listProfiles) {
            if (p.getDni().equals(dni)) {
                return profileMapper.toProfileResponseDTO(p);
            }
        }
        throw new EntityNotFoundException("Perfil no encontrado para DNI: " + dni);
    }


    @Override
    public ProfileResponseDTO updateProfile(UpdateProfileDTO dto) {
        List<Profile> listProfiles = repository.findAll();
        for (Profile p : listProfiles) {
            if (p.getDni().equals(dto.getDni())) {
                p.setEmail(dto.getEmail());
                p.setGender(profileMapper.toGenderDTOFromGender(dto.getGender()));
                p.setLastName(dto.getLastName());
                p.setName(dto.getName());
                p.setPassword(dto.getPassword());
                p.setPhoneNumber(dto.getPhoneNumber());
                p.setUser(dto.getUser());

                Profile updatedProfile = repository.save(p)
                return profileMapper.toProfileResponseDTO(updatedProfile);
            }
        }

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
    public void addReview(Guide guide, Review review) {
        guide.setReview(review);
    }

    @Override
    public void addTrophy(Guide guide, Trophy trophy) {
        guide.getTrophies().add(trophy);
    }

    @Override
    public List<Trophy> getAllTrophies(Guide guide) {
        List<Profile> listProfiles = repository.findAll();
        List<Trophy> trophies = new ArrayList<>();

        for (Profile p : listProfiles) {
            if (p instanceof Guide && p.getDni().equals(guide.getDni())) {
                trophies.addAll(((Guide) p).getTrophies());
            }
        }

        return trophies;
    }
    
    @Override
    public boolean checkAvailability(Guide guide, Date startDate, Date endDate) {
        List<Profile> listProfiles = repository.findAll();
        List<Book> listBooks = bookRepository.findAll();

        for (Profile p : listProfiles) {
            if (p instanceof Guide && p.getDni().equals(guide.getDni())) {
                for(Book b : listBooks) {
                    
                }
            }
        }
    }

    @Override
    public double calculateScore(List<Review> reviews) {

        if (reviews == null || reviews.isEmpty()) 
            return 0.0; 
        
        double totalScore = 0.0;
        for (Review r : reviews){
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
