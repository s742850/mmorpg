package tw.exHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import tw.enums.SkillErrorCode;
import tw.ex.SkillException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class SkillControllerAdvice {
    /**
     * 全局異常捕捉处理
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = SkillException.class)
    public Map errorHandler(SkillException ex) {
        return getMap(ex.getSkillErrorCode());
    }
//    TODO 泛型
    private Map getMap(SkillErrorCode errorCode) {
        Map map = new HashMap<>();
        map.put("code", errorCode.getCode());
        map.put("msg", errorCode.getMessage());
        return map;
    }
}
