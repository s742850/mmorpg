package tw.exHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import tw.enums.WeaponErrorCode;
import tw.ex.WeaponException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class WeaponControllerAdvice {
    /**
     * 全局異常捕捉处理
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = WeaponException.class)
    public Map errorHandler(WeaponException ex) {
        return getMap(ex.getWeaponErrorCode());
    }

    //    TODO 泛型
    private Map getMap(WeaponErrorCode errorCode) {
        Map map = new HashMap<>();
        map.put("code", errorCode.getCode());
        map.put("msg", errorCode.getMessage());
        return map;
    }
}
