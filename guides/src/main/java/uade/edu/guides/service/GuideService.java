package uade.edu.guides.service;

import java.util.List;

import uade.edu.guides.domain.*;
import uade.edu.guides.service.auth.IEstrategiaAutenticacion;

public interface GuideService {
    List<GuideDTO> getAllGuides();

    GuideDTO updateServices(UpdateServiceDTO dto);

    boolean verifyCredential(String credentialId);

    void addReview(AddReviewDTO dto);

    void addTrophy(AddTrophyDTO dto);

    List<TrophyDTO> getAllTrophies(String guideId);

    double calculateScore(List<ReviewDTO> reviews);

    boolean checkAvailability(CheckAvailabilityDTO dto);
}