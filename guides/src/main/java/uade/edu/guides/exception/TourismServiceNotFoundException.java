package uade.edu.guides.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import uade.edu.guides.entity.TourismService;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TourismServiceNotFoundException extends RuntimeException {

    public TourismServiceNotFoundException() {
        super(TourismService.class.getCanonicalName());
    }

}
