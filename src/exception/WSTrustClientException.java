package exception;

public class WSTrustClientException extends Exception {

    public WSTrustClientException(String errorDescription) {

        super(errorDescription);
    }

    public WSTrustClientException(String errorDescription, Throwable cause) {

        super(errorDescription, cause);
    }
}
