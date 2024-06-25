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
public class GuideServiceDTO {

    private Long id;

    private String name;

    private String lastName;

    private List<String> cities;

}
