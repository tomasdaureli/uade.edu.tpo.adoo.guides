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

import uade.edu.guides.domain.CreateProfileDTO;
import uade.edu.guides.domain.ProfileResponseDTO;
import uade.edu.guides.domain.ReviewDTO;
import uade.edu.guides.domain.TrophyDTO;
import uade.edu.guides.domain.UpdateProfileDTO;
import uade.edu.guides.service.ProfileService;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    private ProfileService service;

    @GetMapping
    public List<ProfileResponseDTO> getAllProfiles() {
        return service.getAllProfiles();
    }

    @PostMapping
    public ProfileResponseDTO createUser(
            @RequestBody CreateProfileDTO dto) {
        return service.createUser(dto);
    }

    @GetMapping
    public ProfileResponseDTO getProfileByDNI(
            @RequestParam String dni) {
        return service.getProfileByDNI(dni);
    }

    @PatchMapping("/{profileId}")
    public ProfileResponseDTO updateProfile(
            @PathVariable Long profileId,
            @RequestBody UpdateProfileDTO dto) {
        return service.updateProfile(profileId, dto);
    }

    @PostMapping("{guideId}")
    public void addReview(
            @PathVariable Long guideId,
            @RequestBody ReviewDTO review) {
        service.addReview(guideId, review);
    }

    @PostMapping("{guideId}")
    public void addTrophy(
            @PathVariable Long guideId,
            @RequestBody TrophyDTO trophy) {
        service.addTrophy(guideId, trophy);
    }

    @GetMapping("/trophies/{guideId}")
    public List<TrophyDTO> getAllTrophies(
            @PathVariable Long guideId) {
        return service.getAllTrophies(guideId);
    }

}
