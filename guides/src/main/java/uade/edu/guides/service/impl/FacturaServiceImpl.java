package uade.edu.guides.service.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uade.edu.guides.domain.BookDTO;
import uade.edu.guides.domain.FacturaDTO;
import uade.edu.guides.service.FacturaService;

@Service
@RequiredArgsConstructor
public class FacturaServiceImpl implements FacturaService {

    @Override
    public FacturaDTO getFacturaByBook(BookDTO book) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFacturaByBook'");
    }

}
