package uade.edu.guides.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/books")
public class BookController {

    @PostMapping
    public String createBook(@RequestBody String entity) {
        // TODO: process POST request
        return entity;
    }

}
