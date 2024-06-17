package uade.edu.guides.service.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uade.edu.guides.repository.BookRepository;
import uade.edu.guides.service.BookService;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

}
