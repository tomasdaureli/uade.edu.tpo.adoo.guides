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

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository repository;

    private final ProfileMapper profileMapper;

    private final IEstrategiaAutenticacion autenticacionExterna;
    private final IEstrategiaAutenticacion autenticacionLocal;

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
            this.cambiarEstrategiaAutenticacion(savedProfile.getId(), autenticacionLocal);
        } else {
            this.cambiarEstrategiaAutenticacion(savedProfile.getId(), autenticacionExterna);
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
    public ProfileResponseDTO autenticarUsuario(AuthenticateUserDTO authDto) {
        Profile profile = repository.findByEmail(authDto.getEmail())
                .orElseThrow(ProfileNotFoundException::new);

        if (AuthTypeDTO.INTERNAL.equals(AuthTypeDTO.valueOf(profile.getAutenticacion()))
                && Boolean.TRUE.equals(
                        autenticacionLocal.autenticarUsuario(authDto))) {
            return profileMapper.toProfileResponseDTO(profile);
        } else {
            if (Boolean.TRUE.equals(autenticacionExterna.autenticarUsuario(authDto))) {
                return profileMapper.toProfileResponseDTO(profile);
            }
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
}
