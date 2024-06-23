package uade.edu.guides.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;

import uade.edu.guides.domain.FacturaDTO;
import uade.edu.guides.entity.Factura;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FacturaMapper {

    FacturaDTO toFacturaDTO(Factura factura);

}