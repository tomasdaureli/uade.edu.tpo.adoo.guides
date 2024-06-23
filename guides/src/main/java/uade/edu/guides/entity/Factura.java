package uade.edu.guides.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "facturas")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nroFactura;

    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private Book reserva;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Tourist turista;

    private Double comision = 1.05;

    private Double total;

    private Double pendiente;

}
