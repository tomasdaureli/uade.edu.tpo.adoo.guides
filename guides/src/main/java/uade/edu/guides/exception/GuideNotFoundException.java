package uade.edu.guides.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import uade.edu.guides.entity.Guide;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class GuideNotFoundException extends RuntimeException {

    public GuideNotFoundException() {
        super(Guide.class.getCanonicalName());
    }

}
