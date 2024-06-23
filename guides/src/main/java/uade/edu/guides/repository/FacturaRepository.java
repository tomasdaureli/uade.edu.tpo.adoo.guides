package uade.edu.guides.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uade.edu.guides.entity.Book;
import uade.edu.guides.entity.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {

    Optional<Factura> findByBookId(Long bookId);
    Optional<Factura> findByBook(Book book);

}
