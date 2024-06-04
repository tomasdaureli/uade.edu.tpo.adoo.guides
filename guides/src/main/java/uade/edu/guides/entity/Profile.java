package uade.edu.guides.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Profile {

    private String name;
    private String lastName;
    private Gender gender;
    private String dni;
    private String email;
    private String phoneNumber;
    private String user;
    private String password;
    private List<Trip> historyTrips;

}
