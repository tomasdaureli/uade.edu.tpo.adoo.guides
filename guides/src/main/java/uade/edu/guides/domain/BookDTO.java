package uade.edu.guides.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDTO {

    private Long id;

    private TripDTO trip;

    private ProfileResponseDTO tourist;

    private Double signPayment;

    private Double totalAmount;

    private String status;

}
