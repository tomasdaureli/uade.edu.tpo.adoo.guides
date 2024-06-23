package uade.edu.guides.service.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.FacturaDTO;
import uade.edu.guides.entity.Book;
import uade.edu.guides.entity.Factura;
import uade.edu.guides.entity.Tourist;
import uade.edu.guides.exception.FacturaNotFoundException;
import uade.edu.guides.mapper.FacturaMapper;
import uade.edu.guides.repository.FacturaRepository;
import uade.edu.guides.service.FacturaService;

@Service
@RequiredArgsConstructor
public class FacturaServiceImpl implements FacturaService {

    private final FacturaRepository repository;
    private final FacturaMapper mapper;

    @Override
    public FacturaDTO getFacturaByBook(Long bookID) {
        Factura factura = repository.findByBookId(bookID).orElseThrow(FacturaNotFoundException::new);

        return mapper.toFacturaDTO(factura);
        
    }

    private Double calularTotal(Book book,Factura factura){
        return (book.getTrip().getService().getPrice())*factura.getComision();
    }

    private Double calularPendiente(Book book,Factura factura){
        double sign = book.getSignPayment();
        double servicePrice = (book.getTrip().getService().getPrice())*factura.getComision();
        return (servicePrice - sign);
    }

    @Override
    public void createFactura(Book book, Tourist tourist) {
        Factura factura = new Factura();
        factura.setReserva(book);
        factura.setTurista(tourist);
        factura.setTotal(calularTotal(book,factura));
        factura.setPendiente(calularPendiente(book, factura));
        
        repository.save(factura);

    }

    

}
