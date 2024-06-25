package uade.edu.guides.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uade.edu.guides.service.tourist.IAdapterPago;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("tourist")
public class Tourist extends Profile {

    private Integer totalReviews;

    @Transient
    private IAdapterPago adatperPago;

}
