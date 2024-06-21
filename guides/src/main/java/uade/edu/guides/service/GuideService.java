package uade.edu.guides.service;

import java.util.List;

import uade.edu.guides.domain.*;

public interface GuideService {

    List<ProfileResponseDTO> getAllGuides();

    ProfileResponseDTO updateServices(List<Long> servicesDto);

    boolean verifyCredential(String credentialId);

    void addReview(Long guideId, ReviewDTO review);

    void addTrophy(Long guideId, TrophyDTO trophy);

    List<TrophyDTO> getAllTrophies(String guideId);

}