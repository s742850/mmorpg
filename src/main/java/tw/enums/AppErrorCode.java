package tw.enums;

/**
 * App error code
 */
public enum AppErrorCode {
    ERRORS_ACCOUNT_ID_INVALID(1, "account not found");

    /**
     * 錯誤碼
     */
    private final int code;

    /**
     * 錯誤訊息
     */
    private final String message;

    AppErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
