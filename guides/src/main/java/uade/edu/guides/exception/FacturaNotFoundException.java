package uade.edu.guides.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import uade.edu.guides.entity.Factura;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class FacturaNotFoundException extends RuntimeException {

    public FacturaNotFoundException(){
        super(Factura.class.getCanonicalName());
    }
    
}
