package uade.edu.guides.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

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

    private List<GuideServiceDTO> guides;

}
