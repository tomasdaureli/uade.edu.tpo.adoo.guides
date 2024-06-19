package uade.edu.guides.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.*;
import uade.edu.guides.repository.ProfileRepository;
import uade.edu.guides.service.ProfileService;
import uade.edu.guides.service.auth.IEstrategiaAutenticacion;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository repository;

    @Override
    public List<ProfileResponseDTO> getAllProfiles() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllProfiles'");
    }

    @Override
    public ProfileResponseDTO createUser(CreateProfileDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createUser'");
    }

    @Override
    public ProfileResponseDTO updateProfile(UpdateProfileDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProfile'");
    }

    @Override
    public void autenticarUsuario(AuthenticateUserDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'autenticarUsuario'");
    }

    @Override
    public void cambiarEstrategiaAutenticacion(IEstrategiaAutenticacion estrategia) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cambiarEstrategiaAutenticacion'");
    }

}
