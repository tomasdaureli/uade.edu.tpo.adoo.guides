package uade.edu.guides.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;
import uade.edu.guides.domain.AuthenticateUserDTO;
import uade.edu.guides.domain.CreateProfileDTO;
import uade.edu.guides.domain.CreateServiceDTO;
import uade.edu.guides.domain.ProfileResponseDTO;
import uade.edu.guides.domain.TripDTO;
import uade.edu.guides.domain.UpdateProfileDTO;
import uade.edu.guides.entity.Book;
import uade.edu.guides.entity.Guide;
import uade.edu.guides.entity.Profile;
import uade.edu.guides.entity.Review;
import uade.edu.guides.entity.Trophy;
import uade.edu.guides.service.ProfileService;
import uade.edu.guides.service.auth.IEstrategiaAutenticacion;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private ProfileService pService;

    @GetMapping
    public List<ProfileResponseDTO> getAllProfiles() {    
        return pService.getAllProfiles();
    }

    @PostMapping
    public ProfileResponseDTO createUser(@RequestBody CreateProfileDTO dto) {
        return pService.createUser(dto);
    }


    @GetMapping
    public ProfileResponseDTO getProfileByDNI(@RequestParam String dni) {
        return pService.getProfileByDNI(dni);
    }

  
    @PatchMapping("/{profileId}")
    public ProfileResponseDTO updateProfile(@PathVariable Long profileId , @RequestBody UpdateProfileDTO dto) {
        return pService.updateProfile(dto);
    }

    @PostMapping
    public void addReview(@RequestBody Guide guide, @RequestBody Review review) {
       pService.addReview(guide, review);
    }

    @PostMapping
    public void addTrophy(@RequestBody Guide guide, @RequestBody Trophy trophy) {
       pService.addTrophy(guide, trophy); 
    }

    
    @GetMapping
    public List<Trophy> getAllTrophies(@RequestParam  Guide guide) {
        return pService.getAllTrophies(guide);
    }
    
    @PostMapping
    public List<TripDTO> addTripToHistory(@RequestBody TripDTO trip) {
        return pService.addTripToHistory(trip);
    }



}
