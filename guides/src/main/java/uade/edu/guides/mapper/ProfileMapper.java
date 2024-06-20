package uade.edu.guides.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import uade.edu.guides.domain.CreateProfileDTO;
import uade.edu.guides.domain.CreateServiceDTO;
import uade.edu.guides.domain.GenderDTO;
import uade.edu.guides.domain.ProfileResponseDTO;
import uade.edu.guides.domain.TripDTO;
import uade.edu.guides.domain.UpdateServiceDTO;
import uade.edu.guides.entity.Gender;
import uade.edu.guides.entity.Profile;
import uade.edu.guides.entity.Service;
import uade.edu.guides.entity.Trip;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProfileMapper {

    @Mapping(target = "id", ignore = true)
    Gender toGenderDTOFromGender(GenderDTO gender);

    @Mapping(target = "id", ignore = true)
    GenderDTO toGenderFromGenderDTO(Gender gender);

    @Mapping(target = "id", ignore = true)
    TripDTO toTripDTOFromTrip(Trip trip);

    @Mapping(target = "id", ignore = true)
    List<TripDTO> toListTripDTOFromListTrip(List<Trip> trip);

    @Mapping(target = "id", ignore = true) 
    Profile toProfileEntity(CreateProfileDTO dto);

    @Mapping(target = "id", ignore = true) 
    ProfileResponseDTO toProfileResponseDTO(Profile profile);

    @Mapping(target = "id", ignore = true) 
    ProfileResponseDTO toProfile(Profile profile);

    @Mapping(target = "id", ignore = true) 
    CreateProfileDTO toProfileResponseFromCreateProfileDTO(ProfileResponseDTO dto);



}
