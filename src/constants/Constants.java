package constants;

import java.io.File;

/**
 * Class contains the constant values used across the module.
 */
public class Constants {

    // Trust store location.
    public static final String TRUST_STORE_LOCATION = new File("src/resources/wso2carbon.jks").getAbsolutePath();
    // Trust store password.
    public static final String TRUST_STORE_PASSWORD = "wso2carbon";
    // Security token service endpoint of WSO2 Identity Server.
    public static final String STS_ENDPOINT_URL = "https://localhost:9443/services/wso2carbon-sts";

    // Identifiers used to validate the action performed.
    public static final String ACTION_REQUEST = "Request";
    public static final String ACTION_RENEW = "Renew";
    public static final String ACTION_VALIDATE = "Validate";
}
