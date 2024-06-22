package uade.edu.guides.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import uade.edu.guides.domain.CreateServiceDTO;
import uade.edu.guides.domain.ServiceDTO;
import uade.edu.guides.domain.UpdateServiceDTO;
import uade.edu.guides.entity.TourismService;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TourismServiceMapper {

    @Mapping(target = "id", ignore = true)
    TourismService toServiceFromCreateDTO(CreateServiceDTO dto);

    @Mapping(target = "id", ignore = true)
    TourismService toServiceFromUpdateDTO(UpdateServiceDTO dto, @MappingTarget TourismService service);

    ServiceDTO toServiceDTO(TourismService service);

}
