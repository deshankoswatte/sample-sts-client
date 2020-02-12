package org.wso2.samples.is.sts.wstrust.client.exception;

/**
 * Exception class used to report exceptions caused on the Client's side.
 */
public class WSTrustClientException extends Exception {

    /**
     * Non-Default constructor accepting an exception message.
     *
     * @param exceptionMessage Description of the exception.
     */
    public WSTrustClientException(String exceptionMessage) {

        super(exceptionMessage);
    }

    /**
     * Non-Default constructor accepting an exception message and the cause.
     *
     * @param errorDescription Description of the exception.
     * @param cause            Cause of the exception.
     */
    public WSTrustClientException(String errorDescription, Throwable cause) {

        super(errorDescription, cause);
    }
}
