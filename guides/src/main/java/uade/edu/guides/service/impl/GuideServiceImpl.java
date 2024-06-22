package uade.edu.guides.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.ProfileResponseDTO;
import uade.edu.guides.domain.ReviewDTO;
import uade.edu.guides.domain.TrophyDTO;
import uade.edu.guides.domain.TrophyTypeDTO;
import uade.edu.guides.entity.Guide;
import uade.edu.guides.entity.Review;
import uade.edu.guides.entity.Service;
import uade.edu.guides.entity.Trophy;
import uade.edu.guides.entity.TrophyType;
import uade.edu.guides.mapper.ProfileMapper;
import uade.edu.guides.repository.GuideRepository;
import uade.edu.guides.repository.ServiceRepository;
import uade.edu.guides.service.GuideService;

@Service
@RequiredArgsConstructor
public class GuideServiceImpl implements GuideService {

    private final GuideRepository guideRepository;
    private final ServiceRepository serviceRepository;
    private final ProfileMapper guideMapper;

    public List<ProfileResponseDTO> getAllGuides() {
        List<Guide> listGuides = guideRepository.findAll();
        return listGuides.stream()
                .map(guideMapper::toProfileResponseDTO)
                .collect(Collectors.toList());
    }

    public ProfileResponseDTO updateServices(List<Long> servicesDto, long guideID) {
        
        Guide g = guideRepository.findById(guideID)
            .orElseThrow(() -> new EntityNotFoundException("Guia no encontrado por id: " + guideID));

        Set<Long> currentServiceIds = g.getServices().stream()
            .map(Service::getId)
            .collect(Collectors.toSet());

        Set<Long> newServiceIds = new HashSet<>(servicesDto);

        Set<Long> servicesToAdd = new HashSet<>(newServiceIds);
        servicesToAdd.removeAll(currentServiceIds);

        Set<Long> servicesToRemove = new HashSet<>(currentServiceIds);
        servicesToRemove.removeAll(newServiceIds);

        for (Long serviceId : servicesToAdd) {
            Service service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new EntityNotFoundException("Servicio no encontrado por id: " + serviceId));
            g.addService(service);
        }

        for (Long serviceId : servicesToRemove) {
            Service service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new EntityNotFoundException("Servicio no encontrado por id: " + serviceId));
            g.removeService(service);
        }

        guideRepository.save(g);
        return guideMapper.toProfileResponseDTO(g);
        
    }

    
public boolean verifyCredential(Long credentialId) {
    try {
        guideRepository.findById(credentialId)
            .orElseThrow(() -> new EntityNotFoundException("Credencial no encontrada por id: " + credentialId));
        return true;
    } catch (EntityNotFoundException e) {
        return false;
    }
}


   
    public void addReview(Long guideId, ReviewDTO reviewDto) {
    Guide guide = guideRepository.findById(guideId)
            .orElseThrow(() -> new EntityNotFoundException("Guía no encontrado por id: " + guideId));

    Review newReview = new Review();
    newReview.setComment(reviewDto.getComment());
    newReview.setScore(reviewDto.getScore());

    List<Review> reviews = guide.getReview();

    if (reviews == null) {
        reviews = new ArrayList<>();
        guide.setReview(reviews);
    }

    reviews.add(newReview);

    guideRepository.save(guide);
}


    public void addTrophy(Long guideId, TrophyDTO trophy) {
        Guide guide = guideRepository.findById(guideId)
                .orElseThrow(() -> new EntityNotFoundException("Guía no encontrada por id: " + guideId));

        Trophy newTrophy = new Trophy();

        // Convertir TrophyTypeDTO a TrophyType
        TrophyType trophyType = convertToTrophyType(trophy.getType());
        newTrophy.setType(trophyType);

        List<Trophy> trophies = guide.getTrophies();

        if (trophies == null) {
            trophies = new ArrayList<>();
            guide.setTrophies(trophies);
        }

        trophies.add(newTrophy);

        guideRepository.save(guide);
    }

    // Método de conversión de TrophyTypeDTO a TrophyType
    private TrophyType convertToTrophyType(TrophyTypeDTO trophyTypeDto) {
        return TrophyType.valueOf(trophyTypeDto.name());
    }


    public List<TrophyDTO> getAllTrophies(Long guideId) {
        Guide guide = guideRepository.findById(guideId)
                .orElseThrow(() -> new EntityNotFoundException("Guía no encontrada por id: " + guideId));

        
        List<Trophy> listTrophies = guide.getTrophies();

        return listTrophies.stream()
                .map(guideMapper::toTrophyDTO)
                .collect(Collectors.toList());
    }
}
