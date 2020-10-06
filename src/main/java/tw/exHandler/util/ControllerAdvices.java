package tw.exHandler.util;

import tw.enums.AccountsErrorCode;

import java.util.HashMap;
import java.util.Map;

public class ControllerAdvices {
    public static Map getMap(AccountsErrorCode accountsErrorCode) {
        Map map = new HashMap<>();
        map.put("code", accountsErrorCode.getCode());
        map.put("msg", accountsErrorCode.getMessage());
        return map;
    }
}
