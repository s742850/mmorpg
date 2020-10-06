package tw.ex;

import tw.enums.SkillErrorCode;

/**
 * 技能例外
 */
public class SkillException extends Exception {

    private SkillErrorCode skillErrorCode;


    public SkillException() {
    }

    public SkillException(String message) {
        super(message);
    }

    public SkillException(String message, Throwable cause) {
        super(message, cause);
    }

    public SkillException(Throwable cause) {
        super(cause);
    }

    public SkillException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public SkillException(SkillErrorCode skillErrorCode) {
        this.skillErrorCode = skillErrorCode;
    }

    public SkillErrorCode getSkillErrorCode() {
        return skillErrorCode;
    }

    public void setSkillErrorCode(SkillErrorCode skillErrorCode) {
        this.skillErrorCode = skillErrorCode;
    }


}
