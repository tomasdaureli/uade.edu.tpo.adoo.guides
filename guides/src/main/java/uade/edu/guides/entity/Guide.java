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
public class Guide extends Profile {

    private String credentialId;
    private String photoId;
    private Review review;
    private Double score;
    private List<Trophy> trophies;
    private Boolean booked;
    private List<String> cities;
    private List<Service> services;

}
