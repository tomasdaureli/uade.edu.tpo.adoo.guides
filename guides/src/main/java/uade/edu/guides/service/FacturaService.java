package uade.edu.guides.service;

import uade.edu.guides.domain.BookDTO;
import uade.edu.guides.domain.FacturaDTO;

public interface FacturaService {

    FacturaDTO getFacturaByBook(BookDTO book);

}
