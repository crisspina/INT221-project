package casecoolors.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(ExistImageException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    String ImageException(ExistImageException ex){
        return ex.getMessage();
    }
}
