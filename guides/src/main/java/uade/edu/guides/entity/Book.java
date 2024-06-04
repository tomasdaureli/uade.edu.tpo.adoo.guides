package uade.edu.guides.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Long id;

    private Trip trip;

    private Tourist tourist;

    private Double signPayment;

    private Double totalAmount;

    private IBookStatus status;

}
