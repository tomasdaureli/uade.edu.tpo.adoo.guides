package uade.edu.guides.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "services")
public class TourismService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ServiceType type;

    @Enumerated(EnumType.STRING)
    private Language language;

    private Double price;

    @ManyToMany(mappedBy = "services")
    private List<Guide> guides;

}
