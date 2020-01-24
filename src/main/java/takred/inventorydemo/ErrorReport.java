package takred.inventorydemo;

public class ErrorReport {
    private final int errorCode;
    private final String message;

    public ErrorReport(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}
