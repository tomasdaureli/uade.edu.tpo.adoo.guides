package uade.edu.guides.service;

import java.util.List;

import uade.edu.guides.domain.*;
import uade.edu.guides.entity.Guide;

public interface GuideService {

    ProfileResponseDTO addAdditionalDataForGuide(Long guideId, GuideAdditionalDataDTO dto);

    List<ProfileResponseDTO> getAllGuides();

    ProfileResponseDTO getGuideById(Long guideId);

    ProfileResponseDTO updateServices(Long guideId, GuideUpdateServicesDTO servicesDto);

    void addReview(Guide guide, ReviewDTO review);

}