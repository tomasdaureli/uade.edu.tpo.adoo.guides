package uade.edu.guides.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import uade.edu.guides.domain.*;
import uade.edu.guides.entity.*;
import uade.edu.guides.exception.GuideNotFoundException;
import uade.edu.guides.exception.TourismServiceNotFoundException;
import uade.edu.guides.mapper.ProfileMapper;
import uade.edu.guides.repository.ProfileRepository;
import uade.edu.guides.repository.TourismServiceRepository;
import uade.edu.guides.service.GuideService;

@Slf4j
@Service
@RequiredArgsConstructor
public class GuideServiceImpl implements GuideService {

    private final ProfileRepository profileRepository;

    private final TourismServiceRepository serviceRepository;

    private final ProfileMapper mapper;

    @Override
    public ProfileResponseDTO addAdditionalDataForGuide(Long guideId, GuideAdditionalDataDTO dto) {
        Guide guide = profileRepository.findGuideById(guideId)
                .orElseThrow(GuideNotFoundException::new);

        return mapper.toProfileResponseDTO(
                profileRepository.save(
                        mapper.toGuideFromAdditionalDataDTO(dto, guide)));
    }

    public List<ProfileResponseDTO> getAllGuides() {
        List<Guide> listGuides = profileRepository.findByProfileType();

        return listGuides.stream()
                .map(mapper::toProfileResponseDTOFromGuide)
                .collect(Collectors.toList());
    }

    @Transactional
    public ProfileResponseDTO updateServices(Long guideId, GuideUpdateServicesDTO servicesDto) {
        Guide guide = profileRepository.findGuideById(guideId)
                .orElseThrow(GuideNotFoundException::new);

        Set<Long> currentServiceIds = guide.getServices().stream()
                .map(TourismService::getId)
                .collect(Collectors.toSet());

        Set<Long> newServiceIds = new HashSet<>(servicesDto.getServices());

        guide.getServices().removeIf(service -> !newServiceIds.contains(service.getId()));

        newServiceIds.stream()
                .filter(serviceId -> !currentServiceIds.contains(serviceId))
                .forEach(serviceId -> {
                    TourismService service = serviceRepository.findById(serviceId)
                            .orElseThrow(TourismServiceNotFoundException::new);
                    guide.getServices().add(service);
                });

        return mapper.toProfileResponseDTOFromGuide(guide);

    }

    public void addReview(Long guideId, ReviewDTO reviewDto) {
        Guide guide = profileRepository.findGuideById(guideId)
                .orElseThrow(GuideNotFoundException::new);

        Review newReview = mapper.toReview(reviewDto);

        List<Review> reviews = guide.getReview();

        if (reviews == null) {
            reviews = new ArrayList<>();
            guide.setReview(reviews);
        }

        reviews.add(newReview);

        profileRepository.save(guide);
    }

    public void addTrophy(Long guideId, TrophyDTO trophyDto) {
        Guide guide = profileRepository.findGuideById(guideId)
                .orElseThrow(GuideNotFoundException::new);

        Trophy newTrophy = mapper.toTrophy(trophyDto);

        List<Trophy> trophies = guide.getTrophies();

        if (trophies == null) {
            trophies = new ArrayList<>();
            guide.setTrophies(trophies);
        }

        trophies.add(newTrophy);

        profileRepository.save(guide);
    }

    public List<TrophyDTO> getAllTrophies(Long guideId) {
        Guide guide = profileRepository.findGuideById(guideId)
                .orElseThrow(GuideNotFoundException::new);

        List<Trophy> listTrophies = guide.getTrophies();

        return listTrophies.stream()
                .map(mapper::toTrophyDTO)
                .collect(Collectors.toList());
    }

    private Boolean verifyCredential(String credentialId) {
        Random random = new Random();
        int randomNumber = random.nextInt(2);
        switch (randomNumber) {
            case 0:
                log.info("Credencial válida: {}", credentialId);
                return true;
            case 1:
                log.info("Credencial inválida: {}", credentialId);
                return false;
            default:
                throw new IllegalStateException("Número aleatorio fuera de rango");
        }
    }

    private Double calculateScore(List<Review> reviews) {
        if (reviews == null || reviews.isEmpty())
            return 0.0;

        double totalScore = 0.0;
        for (Review r : reviews) {
            totalScore += r.getScore();
        }

        return totalScore;
    }

}
