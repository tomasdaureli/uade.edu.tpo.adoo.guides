package uade.edu.guides.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.*;
import uade.edu.guides.entity.Profile;
import uade.edu.guides.exception.ProfileNotFoundException;
import uade.edu.guides.mapper.ProfileMapper;
import uade.edu.guides.repository.ProfileRepository;
import uade.edu.guides.service.ProfileService;
import uade.edu.guides.service.auth.IEstrategiaAutenticacion;
import uade.edu.guides.service.auth.strategies.AutenticacionExterna;
import uade.edu.guides.service.auth.strategies.AutenticacionLocal;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository repository;

    private final ProfileMapper profileMapper;

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

        if (AuthTypeDTO.INTERNAL.equals(dto.getAuthType())) {
            this.cambiarEstrategiaAutenticacion(savedProfile.getId(), new AutenticacionLocal());
        } else {
            this.cambiarEstrategiaAutenticacion(savedProfile.getId(), new AutenticacionExterna());
        }

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
    public void autenticarUsuario(Long profileId) {
        Profile profile = repository.findById(profileId)
                .orElseThrow(ProfileNotFoundException::new);

        ProfileResponseDTO profileDTO = profileMapper.toProfileResponseDTO(profile);

        profile.getAutenticacion().autenticarUsuario(profileDTO);
    }

    @Override
    public void cambiarEstrategiaAutenticacion(Long profileId, IEstrategiaAutenticacion estrategia) {
        Profile profile = repository.findById(profileId)
                .orElseThrow(ProfileNotFoundException::new);

        profile.setAutenticacion(estrategia);
    }
}
