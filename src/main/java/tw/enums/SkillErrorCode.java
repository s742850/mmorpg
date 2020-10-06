package tw.enums;

/**
 * 技能錯誤碼
 */
public enum SkillErrorCode {
    SKILL_NOT_FOUND(1, "Skil NOT FOUND"),
    NO_RESULT(2, "SKILL NO RESULT");

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
    SkillErrorCode(int code, String message) {
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
