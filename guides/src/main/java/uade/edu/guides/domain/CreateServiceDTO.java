package uade.edu.guides.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateServiceDTO {

    @NotBlank
    private String name;

    @NotNull
    private ServiceTypeDTO type;

    @NotNull
    private LanguageDTO language;

}
