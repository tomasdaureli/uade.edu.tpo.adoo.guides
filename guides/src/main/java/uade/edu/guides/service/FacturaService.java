package uade.edu.guides.service;

import uade.edu.guides.domain.FacturaDTO;
import uade.edu.guides.entity.Book;
import uade.edu.guides.entity.Factura;
import uade.edu.guides.entity.Tourist;

public interface FacturaService {

    FacturaDTO getFacturaByBook(Long bookID);

    void createFactura(Book book,Tourist tourist);

    void updateFactura(Book book,Double recharge);

}
