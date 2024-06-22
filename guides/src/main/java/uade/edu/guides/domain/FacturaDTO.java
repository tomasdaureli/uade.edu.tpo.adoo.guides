package uade.edu.guides.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDTO {

    private BookDTO reserva;

    private ProfileResponseDTO turista;

    private Double comision;

}
