package uade.edu.guides.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Factura {

    private Book reserva;

    private Tourist turista;

    private Double comision;

}
