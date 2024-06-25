package uade.edu.guides.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.AuthenticateUserDTO;
import uade.edu.guides.domain.CreateProfileDTO;
import uade.edu.guides.domain.GuideAdditionalDataDTO;
import uade.edu.guides.domain.GuideUpdateServicesDTO;
import uade.edu.guides.domain.PaymentTypeDTO;
import uade.edu.guides.domain.ProfileResponseDTO;
import uade.edu.guides.domain.ReviewDTO;
import uade.edu.guides.domain.TrophyDTO;
import uade.edu.guides.domain.UpdateProfileDTO;
import uade.edu.guides.service.GuideService;
import uade.edu.guides.service.ProfileService;
import uade.edu.guides.service.TouristService;

@RestController
@RequestMapping("/profiles")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    private final GuideService guideService;

    private final TouristService touristService;

    @GetMapping
    public List<ProfileResponseDTO> getAllProfiles() {
        return profileService.getAllProfiles();
    }

    @PostMapping
    public ProfileResponseDTO createUser(
            @RequestBody CreateProfileDTO dto) {
        return profileService.createUser(dto);
    }

    @PostMapping("/auth")
    public ProfileResponseDTO autenticarUsuario(
            @Valid @RequestBody AuthenticateUserDTO authDto) {
        return profileService.autenticarUsuario(authDto);
    }

    @PatchMapping("/{profileId}")
    public ProfileResponseDTO updateProfile(
            @PathVariable Long profileId,
            @RequestBody UpdateProfileDTO dto) {
        return profileService.updateProfile(profileId, dto);
    }

    @GetMapping("/guides")
    public List<ProfileResponseDTO> getAllGuides() {
        return guideService.getAllGuides();
    }

    @GetMapping("/guides/{guideId}")
    public ProfileResponseDTO getGuideById(
            @PathVariable Long guideId) {
        return guideService.getGuideById(guideId);
    }

    @PatchMapping("/guides/{guideId}")
    public ProfileResponseDTO addAdditionalDataForGuide(
            @PathVariable Long guideId,
            @Valid @RequestBody GuideAdditionalDataDTO dto) {
        return guideService.addAdditionalDataForGuide(guideId, dto);
    }

    @PatchMapping("/guides/{guideId}/services")
    public ProfileResponseDTO updateServices(
            @PathVariable Long guideId,
            @Valid @RequestBody GuideUpdateServicesDTO dto) {
        return guideService.updateServices(guideId, dto);
    }

    @PostMapping("/guides/reviews/{guideId}")
    public void addReview(
            @PathVariable Long guideId,
            @RequestBody ReviewDTO review) {
        guideService.addReview(guideId, review);
    }

    @GetMapping("/guides/trophies/{guideId}")
    public List<TrophyDTO> getAllTrophies(
            @PathVariable Long guideId) {
        return guideService.getAllTrophies(guideId);
    }

    @GetMapping("/tourists/{touristId}")
    public ProfileResponseDTO getTouristById(
            @PathVariable Long touristId) {
        return touristService.getTouristById(touristId);
    }

    @PostMapping("/tourists/{touristId}/payment/{bookId}")
    public void getTouristById(
            @PathVariable Long touristId,
            @PathVariable Long bookId,
            @RequestParam(required = true) PaymentTypeDTO pay) {
        touristService.realizarPago(touristId, bookId, pay);
    }

}
