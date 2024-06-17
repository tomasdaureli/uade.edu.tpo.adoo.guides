package uade.edu.guides.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import uade.edu.guides.domain.CreateServiceDTO;
import uade.edu.guides.domain.UpdateServiceDTO;
import uade.edu.guides.entity.Service;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ServiceMapper {

    @Mapping(target = "id", ignore = true)
    Service toServiceFromCreateDTO(CreateServiceDTO dto);

    @Mapping(target = "id", ignore = true)
    Service toServiceFromUpdateDTO(UpdateServiceDTO dto, @MappingTarget Service service);

}
