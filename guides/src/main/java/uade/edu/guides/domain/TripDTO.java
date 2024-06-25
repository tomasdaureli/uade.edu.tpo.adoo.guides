package uade.edu.guides.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TripDTO {

    private LocalDate startDate;

    private LocalDate endDate;

    private ProfileResponseDTO guide;

    private ServiceDTO service;

}
