package uade.edu.guides.service;

import java.util.List;

import uade.edu.guides.domain.BookDTO;
import uade.edu.guides.domain.CreateBookDTO;
import uade.edu.guides.domain.FacturaDTO;
import uade.edu.guides.entity.Book;
import uade.edu.guides.service.state.IBookStatus;

public interface BookService {

    BookDTO createBook(CreateBookDTO dto);

    void acceptBook(Long id);

    void changeStatus(Book book, IBookStatus status);

    void sendGuideNotification(Book book);

    void sendTouristNotification(Book book);

    List<BookDTO> getAllBooks();

    BookDTO getBookById(Long id);

    void cancelBook(Long id);

    FacturaDTO getFacturaByBookId(Long bookId);

}
