package uade.edu.guides.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import uade.edu.guides.domain.CreateProfileDTO;
import uade.edu.guides.domain.ProfileResponseDTO;
import uade.edu.guides.domain.TripDTO;
import uade.edu.guides.domain.TrophyDTO;
import uade.edu.guides.domain.UpdateProfileDTO;
import uade.edu.guides.entity.Guide;
import uade.edu.guides.entity.Profile;
import uade.edu.guides.entity.Tourist;
import uade.edu.guides.entity.Trip;
import uade.edu.guides.entity.Trophy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProfileMapper {

    TripDTO toTripDTOFromTrip(Trip trip);

    List<TripDTO> toListTripDTOFromListTrip(List<Trip> trip);

    Guide toGuide(CreateProfileDTO dto);

    Tourist toTourist(CreateProfileDTO dto);

    TrophyDTO toTrophyDTO(Trophy trophy);

    @Mapping(target = "id", ignore = true)
    ProfileResponseDTO toProfileResponseDTO(Profile profile);

    Profile toProfileFromUpdateDTO(UpdateProfileDTO dto, @MappingTarget Profile profile);

}
