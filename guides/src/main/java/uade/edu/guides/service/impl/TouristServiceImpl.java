package uade.edu.guides.service.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.ProfileResponseDTO;
import uade.edu.guides.entity.Tourist;
import uade.edu.guides.exception.ProfileNotFoundException;
import uade.edu.guides.mapper.ProfileMapper;
import uade.edu.guides.repository.ProfileRepository;
import uade.edu.guides.service.TouristService;

@Service
@RequiredArgsConstructor
public class TouristServiceImpl implements TouristService {

    private final ProfileRepository profileRepository;

    private final ProfileMapper mapper;

    @Override
    public ProfileResponseDTO getTouristById(Long touristId) {
        Tourist tourist = profileRepository.findTouristById(touristId)
                .orElseThrow(ProfileNotFoundException::new);

        return mapper.toProfileResponseDTO(tourist);
    }

    @Override
    public void realizarPago(Long touristId, Long bookId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'realizarPago'");
    }

}
