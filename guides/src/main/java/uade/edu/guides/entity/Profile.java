package uade.edu.guides.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "profiles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "profile_type")
public abstract class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String dni;
    private String email;
    private String phoneNumber;
    private String username;
    private String password;
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Trip> historyTrips;
    private String autenticacion;

}
