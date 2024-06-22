package uade.edu.guides.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileResponseDTO {

    private Long id;
    private String name;
    private String lastName;
    private GenderDTO gender;
    private String dni;
    private String email;
    private String phoneNumber;
    private String username;
    private String password;
    private List<TripDTO> historyTrips;
    private String credentialId;
    private String photoId;
    private List<ReviewDTO> review;
    private Double score;
    private List<TrophyDTO> trophies;
    private Boolean booked;
    private List<String> cities;
    private List<ServiceDTO> services;

}
