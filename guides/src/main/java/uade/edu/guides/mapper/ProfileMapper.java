package uade.edu.guides.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import uade.edu.guides.domain.*;
import uade.edu.guides.entity.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProfileMapper {

    TripDTO toTripDTOFromTrip(Trip trip);

    List<TripDTO> toListTripDTOFromListTrip(List<Trip> trip);

    Guide toGuide(CreateProfileDTO dto);

    Tourist toTourist(CreateProfileDTO dto);

    TrophyDTO toTrophyDTO(Trophy trophy);

    ProfileResponseDTO toProfileResponseDTO(Profile profile);

    ProfileResponseDTO toProfileResponseDTOFromGuide(Guide guide);

    Profile toProfileFromUpdateDTO(UpdateProfileDTO dto, @MappingTarget Profile profile);

    Review toReview(ReviewDTO dto);

    Trophy toTrophy(TrophyDTO dto);

    Guide toGuideFromAdditionalDataDTO(GuideAdditionalDataDTO dto, @MappingTarget Guide guide);

}
