package takred.inventorydemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CodedException extends RuntimeException {
    private final Integer errorCode;
    private final Integer responseStatus;

    public CodedException(String message) {
        super(message);
        errorCode = 12;
        responseStatus = 12;
    }

    public CodedException(String message, Integer errorCode, Integer responseStatus) {
        super(message);
        this.errorCode = errorCode;
        this.responseStatus = responseStatus;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public Integer getResponseStatus() {
        return responseStatus;
    }
}
