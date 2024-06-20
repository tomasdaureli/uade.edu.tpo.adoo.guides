package uade.edu.guides.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.BookDTO;
import uade.edu.guides.domain.FacturaDTO;
import uade.edu.guides.domain.ServiceDTO;
import uade.edu.guides.domain.TouristDTO;
import uade.edu.guides.entity.Book;
import uade.edu.guides.entity.IBookStatus;
import uade.edu.guides.repository.BookRepository;
import uade.edu.guides.service.BookService;
import uade.edu.guides.service.FacturaService;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    private final FacturaService facturaService;

    @Override
    public BookDTO createBook(TouristDTO tourist, LocalDate startDate, LocalDate endDate, ServiceDTO service) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createBook'");
    }

    @Override
    public void acceptBook(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'acceptBook'");
    }

    @Override
    public Book changeStatus(IBookStatus status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeStatus'");
    }

    @Override
    public void sendGuideNotification(Book book) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendGuideNotification'");
    }

    @Override
    public void sendTouristNotification(Book book) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendTouristNotification'");
    }

    @Override
    public List<BookDTO> getAllBooks() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllBooks'");
    }

    @Override
    public BookDTO getBookById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBookById'");
    }

    @Override
    public void cancelBook(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancelBook'");
    }

    @Override
    public FacturaDTO getFacturaByBookId(Long bookId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFacturaByBookId'");
    }

}
