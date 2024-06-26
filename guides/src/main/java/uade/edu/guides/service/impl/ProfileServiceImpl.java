package uade.edu.guides.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.*;
import uade.edu.guides.entity.Guide;
import uade.edu.guides.entity.Profile;
import uade.edu.guides.entity.Tourist;
import uade.edu.guides.entity.Trophy;
import uade.edu.guides.exception.GuideNotFoundException;
import uade.edu.guides.exception.ProfileNotFoundException;
import uade.edu.guides.mapper.ProfileMapper;
import uade.edu.guides.repository.ProfileRepository;
import uade.edu.guides.service.GuideService;
import uade.edu.guides.service.ProfileService;
import uade.edu.guides.service.TouristService;
import uade.edu.guides.service.auth.IEstrategiaAutenticacion;
import uade.edu.guides.service.observ.IObserver;

@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository repository;

    private final ProfileMapper profileMapper;

    private final GuideService guideService;

    private final TouristService touristService;

    private final ApplicationContext context;

    private final List<IObserver> listObservers;

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

        profile.setAutenticacion(dto.getAuthType().toString());

        Profile savedProfile = repository.save(profile);

        this.cambiarEstrategiaAutenticacion(savedProfile.getId(),
                getCurrentEstrategiaAuth(savedProfile.getAutenticacion()));

        return profileMapper.toProfileResponseDTO(savedProfile);
    }

    @Override
    public ProfileResponseDTO updateProfile(Long profileId, UpdateProfileDTO dto) {
        Profile profile = repository.findById(profileId)
                .orElseThrow(ProfileNotFoundException::new);

        Profile savedProfile = repository.save(profileMapper.toProfileFromUpdateDTO(dto, profile));

        return profileMapper.toProfileResponseDTO(savedProfile);
    }

    @Override
    public ProfileResponseDTO autenticarUsuario(AuthenticateUserDTO authDto) {
        Profile profile = repository.findByEmail(authDto.getEmail())
                .orElseThrow(ProfileNotFoundException::new);

        if (Boolean.TRUE.equals(getCurrentEstrategiaAuth(
                profile.getAutenticacion()).autenticarUsuario(authDto))) {
            return profileMapper.toProfileResponseDTO(profile);
        }

        throw new IllegalStateException("Mail o contraseña incorrectos.");
    }

    @Override
    public void cambiarEstrategiaAutenticacion(Long profileId, IEstrategiaAutenticacion estrategia) {
        Profile profile = repository.findById(profileId)
                .orElseThrow(ProfileNotFoundException::new);

        profile.setAutenticacion(estrategia.getAutenticacion());

        repository.save(profile);
    }

    private IEstrategiaAutenticacion getCurrentEstrategiaAuth(String estrategia) {
        return (IEstrategiaAutenticacion) context.getBean(estrategia);
    }

    public void createReview(Long guideId, ReviewDTO reviewDto, Long touristId) {
        Guide guide = (Guide) repository.findById(guideId)
                .orElseThrow(GuideNotFoundException::new);
        Tourist tourist = (Tourist) repository.findById(touristId)
                .orElseThrow(ProfileNotFoundException::new);

        guideService.addReview(guide, reviewDto);
        touristService.increaseReviews(tourist);

        if (Boolean.TRUE.equals(isTouristValidToAssignTrophy(tourist))) {
            addTrophy(tourist, new TrophyDTO(TrophyTypeDTO.REVIEW));
        }
        if (Boolean.TRUE.equals(isGuideValidToAssignTrophy(guide))) {
            addTrophy(guide, new TrophyDTO(TrophyTypeDTO.SUCCESS));
        }
    }

    private Boolean isTouristValidToAssignTrophy(Tourist tourist) {
        return tourist.getTotalReviews() >= 10;
    }

    private Boolean isGuideValidToAssignTrophy(Guide guide) {
        return (guide.getScore() >= 4.5)
                && (guide.getReviews().size() >= 10);
    }

    @Override
    public void addTrophy(Profile profile, TrophyDTO trophyDto) {
        listObservers.forEach(o -> o.addTrophyProfile(profile, trophyDto));
    }

    public List<TrophyDTO> getAllTrophies(Long profileId) {
        Profile profile = repository.findById(profileId)
                .orElseThrow(ProfileNotFoundException::new);

        List<Trophy> listTrophies = profile.getTrophies();

        return listTrophies.stream()
                .map(profileMapper::toTrophyDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void attach(IObserver observer) {
        listObservers.add(observer);
    }

    @Override
    public void detach(IObserver observer) {
        listObservers.remove(observer);
    }

}
