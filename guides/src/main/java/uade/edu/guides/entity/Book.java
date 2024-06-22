package uade.edu.guides.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Tourist tourist;

    private Double signPayment;

    private Double totalAmount;

    private String status;

}
