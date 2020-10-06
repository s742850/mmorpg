package tw.enums;

/**
 * 武器錯誤碼, 錯誤訊息
 */
public enum WeaponErrorCode {

    WEAPON_NOT_FOUND(1, "weapon not found"),
    WEAPON_NO_RESULT(2, "no result"),
    ROLE_HAS_THIS_WEAPON(3, "role has this weapon, so cannot delete");

    /**
     * 錯誤碼
     */
    private final int code;

    /**
     * 錯誤訊息
     */
    private final String message;

    WeaponErrorCode(int code, String message) {
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
