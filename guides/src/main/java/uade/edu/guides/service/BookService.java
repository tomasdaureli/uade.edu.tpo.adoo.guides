package uade.edu.guides.service;

import java.time.LocalDate;
import java.util.List;

import uade.edu.guides.domain.BookDTO;
import uade.edu.guides.domain.FacturaDTO;
import uade.edu.guides.domain.ServiceDTO;
import uade.edu.guides.domain.TouristDTO;
import uade.edu.guides.entity.Book;
import uade.edu.guides.entity.IBookStatus;

public interface BookService {

    BookDTO createBook(TouristDTO tourist, LocalDate startDate, LocalDate endDate, ServiceDTO service);

    void acceptBook(Long id);

    Book changeStatus(IBookStatus status);

    void sendGuideNotification(Book book);

    void sendTouristNotification(Book book);

    List<BookDTO> getAllBooks();

    BookDTO getBookById(Long id);

    void cancelBook(Long id);

    FacturaDTO getFacturaByBookId(Long bookId);

}
