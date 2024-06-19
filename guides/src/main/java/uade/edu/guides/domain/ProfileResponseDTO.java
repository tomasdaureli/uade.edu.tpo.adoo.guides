package uade.edu.guides.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileResponseDTO {

    private Long id;
    private String name;
    private String lastName;
    private GenderDTO gender;
    private String dni;
    private String email;
    private String phoneNumber;
    private String user;
    private String password;
    private List<TripDTO> historyTrips;

}
