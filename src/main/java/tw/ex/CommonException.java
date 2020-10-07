package tw.ex;

import tw.enums.CommonErrorCode;

public class CommonException extends Exception{
    CommonErrorCode commonErrorCode;

    public CommonException(CommonErrorCode commonErrorCode) {
        this.commonErrorCode = commonErrorCode;
    }

    public CommonException(String message, CommonErrorCode commonErrorCode) {
        super(message);
        this.commonErrorCode = commonErrorCode;
    }

    public CommonException(String message, Throwable cause, CommonErrorCode commonErrorCode) {
        super(message, cause);
        this.commonErrorCode = commonErrorCode;
    }

    public CommonException(Throwable cause, CommonErrorCode commonErrorCode) {
        super(cause);
        this.commonErrorCode = commonErrorCode;
    }

    public CommonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, CommonErrorCode commonErrorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.commonErrorCode = commonErrorCode;
    }

    public CommonErrorCode getCommonErrorCode() {
        return commonErrorCode;
    }
}
