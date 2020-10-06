package tw.ex;

import tw.enums.WeaponErrorCode;

/**
 * 武器例外
 */
public class WeaponException extends Exception {

    private WeaponErrorCode weaponErrorCode;

    public WeaponException(WeaponErrorCode weaponErrorCode) {
        this.weaponErrorCode = weaponErrorCode;
    }

    public WeaponException(String message, WeaponErrorCode weaponErrorCode) {
        super(message);
        this.weaponErrorCode = weaponErrorCode;
    }

    public WeaponException(String message, Throwable cause, WeaponErrorCode weaponErrorCode) {
        super(message, cause);
        this.weaponErrorCode = weaponErrorCode;
    }

    public WeaponException(Throwable cause, WeaponErrorCode weaponErrorCode) {
        super(cause);
        this.weaponErrorCode = weaponErrorCode;
    }

    public WeaponException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, WeaponErrorCode weaponErrorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.weaponErrorCode = weaponErrorCode;
    }

    public WeaponErrorCode getWeaponErrorCode() {
        return weaponErrorCode;
    }
}
