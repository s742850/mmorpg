package tw.enums;

/**
 * App錯誤碼, 訊息
 */
public enum RoleErrorCode {
    /**
     * 沒有結果
     */
    NO_RESULT(1, "errors.no.result"),

    /**
     * 此accountID與account table不匹配
     */
    ERRORS_ACCOUNT_ID_INVALID(2, "errors.account_id_invalid"),

    ERRORS_ROLE_ID(3, "errors_role_id"),

    /**
     * 無效。
     */
    ERRORS_INVALID(4, "errors.invalid"),


    /**
     * 角色技能重複, 已經有這筆資料了。
     */
    ROLE_SKILL_DUPLICATE(4, "role skill duplicate");

    /**
     * 錯誤碼
     */
    private final int code;

    /**
     * 錯誤訊息
     */
    private final String message;

    /**
     * @param code    錯誤碼
     * @param message 錯誤訊息
     */
    RoleErrorCode(int code, String message) {
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
