package uade.edu.guides.service;

import java.util.List;

import uade.edu.guides.domain.BookDTO;
import uade.edu.guides.domain.CreateBookDTO;
import uade.edu.guides.entity.Book;
import uade.edu.guides.service.state.IBookStatus;

public interface BookService {

    BookDTO createBook(CreateBookDTO dto);

    void acceptBook(Long id);

    void changeStatus(Book book, IBookStatus status);

    void sendTouristNotification(Book book,IBookStatus status);

    List<BookDTO> getAllBooks();

    List<BookDTO> getBooksByTourist(Long touristId);

    BookDTO getBookById(Long id);

    void cancelBook(Long id,Long profileId);

}
