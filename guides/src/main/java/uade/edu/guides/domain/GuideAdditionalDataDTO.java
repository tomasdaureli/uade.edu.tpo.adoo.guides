package uade.edu.guides.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GuideAdditionalDataDTO {

    @NotBlank
    private String credentialId;

    @NotBlank
    private String photoId;

}
