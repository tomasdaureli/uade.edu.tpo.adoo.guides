package uade.edu.guides.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDTO {

    private Long id;

    private String name;

    private ServiceTypeDTO type;

    private LanguageDTO language;

    private Double price;

}
