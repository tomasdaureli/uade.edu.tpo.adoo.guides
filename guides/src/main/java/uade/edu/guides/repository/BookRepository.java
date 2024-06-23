package uade.edu.guides.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uade.edu.guides.entity.Book;
import uade.edu.guides.entity.Tourist;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTourist(Tourist tourist);

}
