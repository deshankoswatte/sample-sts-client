package org.wso2.samples.is.sts.wstrust.client.exception;

/**
 * Exception class used to report exceptions caused on the org.wso2.samples.is.sts.wstrust.client.Client's side.
 */
public class WSTrustClientException extends Exception {

    /**
     * Non-Default constructor accepting an org.wso2.samples.is.sts.wstrust.client.exception message.
     *
     * @param exceptionMessage Description of the org.wso2.samples.is.sts.wstrust.client.exception.
     */
    public WSTrustClientException(String exceptionMessage) {

        super(exceptionMessage);
    }

    /**
     * Non-Default constructor accepting an org.wso2.samples.is.sts.wstrust.client.exception message and the cause.
     *
     * @param errorDescription Description of the org.wso2.samples.is.sts.wstrust.client.exception.
     * @param cause            Cause of the org.wso2.samples.is.sts.wstrust.client.exception.
     */
    public WSTrustClientException(String errorDescription, Throwable cause) {

        super(errorDescription, cause);
    }
}
