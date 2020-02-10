package constants;

import java.io.File;

public class Constants {

    public static final String TRUST_STORE_LOCATION =  new File("src/resources/wso2carbon.jks").getAbsolutePath();
    public static final String TRUST_STORE_PASSWORD = "wso2carbon";
    public static final String STS_ENDPOINT_URL = "https://localhost:9443/services/wso2carbon-sts";
    public static final String ACTION_REQUEST = "Request";
    public static final String ACTION_RENEW = "Renew";
    public static final String ACTION_VALIDATE = "Validate";
}
