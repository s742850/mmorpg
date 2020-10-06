package tw.ex;

import tw.enums.RoleErrorCode;

/**
 * 角色例外
 */
public class RoleException extends Exception {

    private RoleErrorCode roleErrorCode;

    public RoleException(RoleErrorCode roleErrorCode) {
        this.roleErrorCode = roleErrorCode;
    }

    public RoleException(String message, RoleErrorCode roleErrorCode) {
        super(message);
        this.roleErrorCode = roleErrorCode;
    }

    public RoleException(String message, Throwable cause, RoleErrorCode roleErrorCode) {
        super(message, cause);
        this.roleErrorCode = roleErrorCode;
    }

    public RoleException(Throwable cause, RoleErrorCode roleErrorCode) {
        super(cause);
        this.roleErrorCode = roleErrorCode;
    }

    public RoleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, RoleErrorCode roleErrorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.roleErrorCode = roleErrorCode;
    }

    public RoleErrorCode getRoleErrorCode() {
        return roleErrorCode;
    }
}
