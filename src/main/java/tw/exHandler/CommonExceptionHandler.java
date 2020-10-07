package tw.exHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import tw.enums.CommonErrorCode;
import tw.ex.CommonException;
import tw.response.CommonResponse;
import tw.response.IErrorCode;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用exception handler
 */
@ControllerAdvice
public class CommonExceptionHandler {

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


        return getMap(CommonErrorCode.ERRORS_ACCOUNT_ID_INVALID);
    }


    @ExceptionHandler(CommonException.class)
    @ResponseBody
    ResponseEntity handlerBindException(CommonException ex) {
        CommonResponse commonResponse = new CommonResponse(false
                , ex.getCommonErrorCode().getCode()
                , ex.getCommonErrorCode().getMessage());
        return ResponseEntity.status(400).body(commonResponse);
    }


    private Map getMap(IErrorCode errorCode) {
        Map map = new HashMap<>();
        map.put("code", errorCode.getCode());
        map.put("msg", errorCode.getMessage());
        return map;
    }
}
