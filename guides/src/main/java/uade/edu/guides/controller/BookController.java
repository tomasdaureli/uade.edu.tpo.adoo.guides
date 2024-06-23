package uade.edu.guides.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.BookDTO;
import uade.edu.guides.domain.CreateBookDTO;
import uade.edu.guides.domain.FacturaDTO;
import uade.edu.guides.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return service.getAllBooks();
    }

    @PostMapping
    public BookDTO createBook(
            @Valid @RequestBody CreateBookDTO dto) {
        return service.createBook(dto);
    }

    @GetMapping("/{bookId}")
    public BookDTO getBookById(
            @PathVariable Long bookId) {
        return service.getBookById(bookId);
    }

    @PatchMapping("/accept/{bookId}")
    public void acceptBook(
            @PathVariable Long bookId) {
        service.acceptBook(bookId);
    }

    @PatchMapping("/cancel/{bookId}")
    public void cancelBook(
            @PathVariable Long bookId) {
        service.cancelBook(bookId);
    }

    @GetMapping("/{bookId}/bill")
    public FacturaDTO getBillByBook(
            @PathVariable Long bookId) {
        return service.getFacturaByBookId(bookId);
    }

    @GetMapping("/{touristId}")
    public List<BookDTO> getBooksByTourist(
            @PathVariable Long touristId) {
        return service.getBooksByTourist(touristId);
    }

}
