package tw.enums;

/**
 * 帳號錯誤碼, 錯誤訊息
 */
public enum AccountsErrorCode {

    ACCOUNT_NOT_FOUND(1, "account not found"),
    ACCOUNT_NO_RESULT(2, "no result"),
    ACCOUNT_DUPLICATE(3, "account duplicate");

    /**
     * 錯誤碼
     */
    private final int code;

    /**
     * 錯誤訊息
     */
    private final String message;

    AccountsErrorCode(int code, String message) {
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
