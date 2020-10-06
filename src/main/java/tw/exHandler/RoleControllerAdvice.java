package tw.exHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import tw.enums.RoleErrorCode;
import tw.ex.RoleException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RoleControllerAdvice {

    /**
     * 全局異常捕捉处理
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = RoleException.class)
    public Map errorHandler(RoleException ex) {
        return getMap(ex.getRoleErrorCode());
    }

//    /**
//     * 全局異常捕捉处理
//     *
//     * @param ex
//     * @return
//     * @link https://my.oschina.net/ethan09/blog/203729
//     */
//    @ResponseBody
//    @ExceptionHandler(value = EntityNotFoundException.class)
//    public Map errorHandler(EntityNotFoundException ex) {
//        return getMap(RoleErrorCode.ERRORS_ACCOUNT_ID_INVALID);
//    }

    private Map getMap(RoleErrorCode roleErrorCode) {
        Map map = new HashMap<>();
        map.put("code", roleErrorCode.getCode());
        map.put("msg", roleErrorCode.getMessage());
        return map;
    }


}
