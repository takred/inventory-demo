package takred.inventorydemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CodeException extends RuntimeException {
    private final Integer errorCode;
    public CodeException(String message) {
        super(message);
        errorCode = 12;
    }

    public CodeException(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
