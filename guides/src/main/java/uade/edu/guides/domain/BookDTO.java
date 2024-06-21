package uade.edu.guides.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private Long id;

    private TripDTO trip;

    private ProfileResponseDTO tourist;

    private Double signPayment;

    private Double totalAmount;

    private String status;

}
