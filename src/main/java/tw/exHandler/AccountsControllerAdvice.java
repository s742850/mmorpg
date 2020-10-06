package tw.exHandler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tw.enums.AccountsErrorCode;
import tw.ex.AccountsException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AccountsControllerAdvice {


    @ExceptionHandler(value = AccountsException.class)
    public Map errorHandler(AccountsException ex) {
        return getMap(ex.getAccountsErrorCode());
    }

    private Map getMap(AccountsErrorCode accountsErrorCode) {
        Map map = new HashMap<>();
        map.put("code", accountsErrorCode.getCode());
        map.put("msg", accountsErrorCode.getMessage());
        return map;
    }
}
