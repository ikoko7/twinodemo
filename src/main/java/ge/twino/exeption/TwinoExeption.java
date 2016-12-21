package ge.twino.exeption;

/**
 * Created by SHEMO on 12/21/2016.
 */
public class TwinoExeption extends Exception{

    private static final long serialVersionUID = 1L;

    Integer errorCode;
    String errorMessage;

    public TwinoExeption(Exception e) {
        super(e);
        errorCode = -1;
        errorMessage = "";

        String classNameMessage = getExceptionClassName(e);

        if (e.getMessage() != null)
            errorMessage = classNameMessage + ", " + e.getMessage();
        else
            errorMessage = classNameMessage;
    }

    private String getExceptionClassName(Exception e) {

        String className = new String();
        String classNameMessage = new String("");

        Class<? extends Exception> eClass = e.getClass();

        if (eClass != null) {

            className = eClass.getSimpleName();
            String words[] = className.split("(?=[A-Z])"); // Split Name by Upper Case for readability

            // put the Name back together, now with spaces between words
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (i > 0 && word.length() > 1)
                    classNameMessage = classNameMessage.concat(" ");
                classNameMessage = classNameMessage.concat(word);
            }
        }

        return classNameMessage.trim();
    }

    public TwinoExeption(Integer errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public TwinoExeption(Integer errorCode, TwinoResponseMessage responseMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = responseMessage.getResponseMessage();
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getMessage() {
        return getErrorMessage();

    }
    
    
}
