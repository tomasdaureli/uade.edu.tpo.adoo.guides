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
import uade.edu.guides.service.credent.IAdapterIA;
import uade.edu.guides.service.observ.IObserver;

@Slf4j
@Service
@RequiredArgsConstructor
public class GuideServiceImpl implements GuideService {

    private final ProfileRepository profileRepository;

    private final TourismServiceRepository serviceRepository;

    private final ProfileMapper mapper;

    private final IAdapterIA adapterIa;

    private List<IObserver> listObservers;

    @Override
    public ProfileResponseDTO addAdditionalDataForGuide(Long guideId, GuideAdditionalDataDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAdditionalDataForGuide'");
    }

    public List<ProfileResponseDTO> getAllGuides() {
        List<Guide> listGuides = profileRepository.findByProfileType();

        return listGuides.stream()
                .map(mapper::toProfileResponseDTOFromGuide)
                .collect(Collectors.toList());
    }

    @Transactional
    public ProfileResponseDTO updateServices(Long guideId, List<Long> servicesDto) {
        Guide guide = profileRepository.findByIdAndProfileType(guideId)
                .orElseThrow(GuideNotFoundException::new);

        Set<Long> currentServiceIds = guide.getServices().stream()
                .map(TourismService::getId)
                .collect(Collectors.toSet());

        Set<Long> newServiceIds = new HashSet<>(servicesDto);

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
        Guide guide = profileRepository.findByIdAndProfileType(guideId)
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
        listObservers.forEach(o -> o.addTrophyGuide(guideId, trophyDto));
    }

    public List<TrophyDTO> getAllTrophies(Long guideId) {
        Guide guide = profileRepository.findByIdAndProfileType(guideId)
                .orElseThrow(GuideNotFoundException::new);

        List<Trophy> listTrophies = guide.getTrophies();

        return listTrophies.stream()
                .map(mapper::toTrophyDTO)
                .collect(Collectors.toList());
    }

    public Boolean verifyCredential(String credentialId) {
        return adapterIa.verifyCredential(credentialId);
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

    @Override
    public void attach(IObserver observer) {
        listObservers.add(observer);
    }

    @Override
    public void detach(IObserver observer) {
        listObservers.remove(observer);
    }

}
