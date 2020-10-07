package tw.response;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 統一回應務件
 *
 * @link https://matthung0807.blogspot.com/2019/08/jackson-jsoninclude.html
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse {

    /**
     * true成功, false失敗
     */
    private boolean success;
    private String errorCode;
    private Object data;

    public CommonResponse() {

    }

    public CommonResponse(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public CommonResponse(String errorCode, Object data) {
        this(false, errorCode, data);
    }

    public CommonResponse(boolean success, String errorCode, Object data) {
        this.success = success;
        this.errorCode = errorCode;
        this.data = data;
    }

    public CommonResponse(Object data) {
        this(true, data);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
