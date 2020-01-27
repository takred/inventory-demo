package takred.inventorydemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import takred.inventorydemo.exception.CodedException;

@ControllerAdvice
public class CodedExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value
            = { CodedException.class })
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "{ \"ggh\": \"" + ex.getMessage() + "   " + ((CodedException)ex).getErrorCode() + "\"}";
        ResponseEntity<Object> response = ResponseEntity.status(((CodedException) ex).getResponseStatus())
                .body(new ErrorReport(((CodedException) ex).getErrorCode(), ex.getMessage(), ((CodedException) ex).getResponseStatus()));
        return response;
        //return handleExceptionInternal(ex, bodyOfResponse,
        //        new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

}
