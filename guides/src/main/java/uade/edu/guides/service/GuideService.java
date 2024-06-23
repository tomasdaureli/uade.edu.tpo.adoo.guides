package uade.edu.guides.service;

import java.util.List;

import uade.edu.guides.domain.*;
import uade.edu.guides.service.observ.IObserver;

public interface GuideService {

    ProfileResponseDTO addAdditionalDataForGuide(Long guideId, GuideAdditionalDataDTO dto);

    List<ProfileResponseDTO> getAllGuides();

    ProfileResponseDTO getGuideById(Long guideId);

    ProfileResponseDTO updateServices(Long guideId, GuideUpdateServicesDTO servicesDto);

    void addReview(Long guideId, ReviewDTO review);

    void addTrophy(Long guideId, TrophyDTO trophy);

    void attach(IObserver observer);

    void detach(IObserver observer);

    List<TrophyDTO> getAllTrophies(Long guideId);

}