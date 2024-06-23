package uade.edu.guides.service;

import java.util.List;

import uade.edu.guides.domain.*;

public interface GuideService {

    ProfileResponseDTO addAdditionalDataForGuide(Long guideId, GuideAdditionalDataDTO dto);

    List<ProfileResponseDTO> getAllGuides();

    ProfileResponseDTO updateServices(Long guideId, GuideUpdateServicesDTO servicesDto);

    void addReview(Long guideId, ReviewDTO review);

    void addTrophy(Long guideId, TrophyDTO trophy);

    List<TrophyDTO> getAllTrophies(Long guideId);

}