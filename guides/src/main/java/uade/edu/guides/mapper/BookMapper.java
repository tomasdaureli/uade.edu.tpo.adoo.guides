package uade.edu.guides.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;

import uade.edu.guides.domain.BookDTO;
import uade.edu.guides.domain.CreateBookDTO;
import uade.edu.guides.entity.Book;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BookMapper {

    Book toBookFromCreateDTO(CreateBookDTO dto);

    BookDTO toBookDTO(Book book);

}
