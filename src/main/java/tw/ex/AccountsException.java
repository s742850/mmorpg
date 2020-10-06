package tw.ex;

import tw.enums.AccountsErrorCode;

/**
 * 帳號例外
 */
public class AccountsException extends Exception {

    private AccountsErrorCode accountsErrorCode;

    public AccountsException(AccountsErrorCode accountsErrorCode) {
        this.accountsErrorCode = accountsErrorCode;
    }

    public AccountsException(String message, AccountsErrorCode accountsErrorCode) {
        super(message);
        this.accountsErrorCode = accountsErrorCode;
    }

    public AccountsException(String message, Throwable cause, AccountsErrorCode accountsErrorCode) {
        super(message, cause);
        this.accountsErrorCode = accountsErrorCode;
    }

    public AccountsException(Throwable cause, AccountsErrorCode accountsErrorCode) {
        super(cause);
        this.accountsErrorCode = accountsErrorCode;
    }

    public AccountsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, AccountsErrorCode accountsErrorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.accountsErrorCode = accountsErrorCode;
    }

    public AccountsErrorCode getAccountsErrorCode() {
        return accountsErrorCode;
    }

}
