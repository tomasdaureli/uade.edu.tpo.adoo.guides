package uade.edu.guides.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Service {

    private Long id;
    private String name;
    private ServiceType type;
    private Language language;
}
