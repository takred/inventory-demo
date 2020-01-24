package takred.inventorydemo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import takred.inventorydemo.exception.ObjectNotFoundException;

@ControllerAdvice
public class CodedExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value
            = { ObjectNotFoundException.class })
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "{ \"ggh\": \"" + ex.getMessage() + "   " + ((ObjectNotFoundException)ex).getErrorCode() + "\"}";
        ResponseEntity<Object> response = ResponseEntity.status(400)
                .body(new ErrorReport(((ObjectNotFoundException) ex).getErrorCode(), ex.getMessage()));
        return response;
        //return handleExceptionInternal(ex, bodyOfResponse,
        //        new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

}
