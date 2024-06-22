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

    private Long credentialId;
    private String photoId;
    private List<Review> review;
    private Double score;
    private List<Trophy> trophies;
    private Boolean booked;
    private List<String> cities;
    private List<Service> services;
    
}
