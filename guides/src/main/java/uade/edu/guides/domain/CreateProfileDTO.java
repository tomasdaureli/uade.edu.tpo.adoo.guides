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
public class CreateProfileDTO {

    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotNull
    private GenderDTO gender;
    @NotBlank
    private String dni;
    @NotBlank
    private String email;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String user;
    @NotBlank
    private String password;
    @NotNull
    private ProfileTypeDTO type;

}
