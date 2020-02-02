package takred.inventorydemo;

import lombok.Data;

@Data
public class ErrorReport {
    private final int errorCode;
    private final String message;
    private final Integer responseStatus;

    public ErrorReport(int errorCode, String message, Integer responseStatus) {
        this.errorCode = errorCode;
        this.message = message;
        this.responseStatus = responseStatus;
    }
}
