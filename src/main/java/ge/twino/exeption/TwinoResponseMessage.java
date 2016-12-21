package ge.twino.exeption;

import ge.twino.utils.GsonUtils;

/**
 * Created by SHEMO on 12/21/2016.
 */
public class TwinoResponseMessage {
    private int returnCode;
    private String returnStatus;
    private String errorSource;

    public TwinoResponseMessage() {
        returnCode = -1;
        returnStatus = null;
        errorSource = null;
    }

    public TwinoResponseMessage(int code, String status, String source) {
        returnCode = code;
        returnStatus = status;
        errorSource = source;
    }


    public TwinoResponseMessage(TwinoResponseMessage obj) {
        this(obj.getReturnCode(), obj.getReturnStatus(), obj.getErrorSource());
    }


    public int getReturnCode() {
        return returnCode;
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public String getErrorSource() {
        return errorSource;
    }

    public String getResponseMessage() {
        return GsonUtils.createGson().toJson(this, TwinoResponseMessage.class);
    }
}
