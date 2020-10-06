package tw.exHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import tw.enums.AppErrorCode;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class AppExceptionHandler {

    /**
     * 全局異常捕捉处理
     *
     * @param ex
     * @return
     * @link https://my.oschina.net/ethan09/blog/203729
     */
    @ResponseBody
    @ExceptionHandler(value = EntityNotFoundException.class)
    public Map errorHandler(EntityNotFoundException ex) {
        return getMap(AppErrorCode.ERRORS_ACCOUNT_ID_INVALID);
    }

    private Map getMap(AppErrorCode appErrorCode) {
        Map map = new HashMap<>();
        map.put("code", appErrorCode.getCode());
        map.put("msg", appErrorCode.getMessage());
        return map;
    }
}
