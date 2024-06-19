package uade.edu.guides.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uade.edu.guides.entity.Profile;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NotificacionDTO {

    private String mensaje;

    private String descripcion;

    private Profile receptor;

}
