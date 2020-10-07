package tw.enums;

import tw.response.IErrorCode;

/**
 * App error code
 */
public enum CommonErrorCode implements IErrorCode {
    ERRORS_ACCOUNT_ID_INVALID("account001", "account not found"),
    ACCOUNT_NO_ID("account002", "沒有這個帳號ID"),
    ACCOUNT_DUPLICATE("ACCOUNT003", "account duplicate");


    /**
     * 錯誤碼
     */
    private final String code;

    /**
     * 錯誤訊息
     */
    private final String message;

    CommonErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
