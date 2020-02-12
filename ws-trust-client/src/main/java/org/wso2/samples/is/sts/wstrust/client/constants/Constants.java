package org.wso2.samples.is.sts.wstrust.client.constants;

/**
 * Class contains the constant values used across the module.
 */
public class Constants {

    // Trust store name.
    public static final String TRUST_STORE = "wso2carbon.jks";
    // Trust store password.
    public static final String TRUST_STORE_PASSWORD = "wso2carbon";
    // Security token service endpoint of WSO2 Identity Server.
    public static final String STS_ENDPOINT_URL = "https://localhost:9443/services/wso2carbon-sts";

    // Identifiers used to validate the action performed.
    public static final String ACTION_REQUEST = "Request";
    public static final String ACTION_RENEW = "Renew";
    public static final String ACTION_VALIDATE = "Validate";

    // Attributes for templating.
    public static final String CREATION_TIME = "creationTime";
    public static final String EXPIRY_TIME = "expiryTime";
    public static final String URI = "uri";

    // Template file names.
    public static final String REQUEST_ST_TEMPLATE = "templates/request_security_token_RST.xml";
    public static final String RENEW_ST_TEMPLATE = "templates/renew_security_token_RST.xml";
    public static final String VALIDATE_ST_TEMPLATE = "templates/validate_security_token_RST.xml";

    public static final String GREEN_COLOR = "\033[1;32m";
    public static final String RESET_COLOR = "\033[0m";
}
