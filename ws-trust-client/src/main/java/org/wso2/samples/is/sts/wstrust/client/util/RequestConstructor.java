package org.wso2.samples.is.sts.wstrust.client.util;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.File;
import java.io.StringWriter;
import java.util.Properties;

import static org.wso2.samples.is.sts.wstrust.client.constants.Constants.CREATION_TIME;
import static org.wso2.samples.is.sts.wstrust.client.constants.Constants.EXPIRY_TIME;
import static org.wso2.samples.is.sts.wstrust.client.constants.Constants.RENEW_ST_TEMPLATE;
import static org.wso2.samples.is.sts.wstrust.client.constants.Constants.REQUEST_ST_TEMPLATE;
import static org.wso2.samples.is.sts.wstrust.client.constants.Constants.URI;
import static org.wso2.samples.is.sts.wstrust.client.constants.Constants.VALIDATE_ST_TEMPLATE;

/**
 * RequestConstructor class builds the RequestSecurityTokens for each action performed.
 */
public class RequestConstructor {

    private static VelocityEngine velocityEngine = new VelocityEngine();
    private static boolean isVEInitialized = false;
    private static Template requestSTTemplate;
    private static Template renewSTTemplate;
    private static Template validateSTTemplate;
    private static StringWriter stringWriter = new StringWriter();

    /**
     * Build a RST which is required for requesting a security token
     * from the Security Token Service.
     *
     * @param creationTime Creation time of the Request Security Token.
     * @param expiryTime   Expiry time of the Request Security Token.
     * @return A soap request containing the Request Security Token
     * used to request a security token.
     */
    public static String buildRSTToRequestSecurityToken(String creationTime, String expiryTime) {

        initVelocityEngine();
        clearStringWriter();

        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put(CREATION_TIME, creationTime);
        velocityContext.put(EXPIRY_TIME, expiryTime);

        requestSTTemplate.merge(velocityContext, stringWriter);

        return stringWriter.toString();
    }

    /**
     * Build a RST which is required for renewing a security token from
     * the Security Token Service.
     *
     * @param creationTime Creation time of the Request Security Token.
     * @param expiryTime   Expiry time of the Request Security Token.
     * @param uri          Identifier for the Security Token  to be validated.
     * @return A soap request containing the Request Security Token used
     * to renew a security token.
     */
    public static String buildRSTToRenewSecurityToken(String creationTime, String expiryTime, String uri) {

        initVelocityEngine();
        clearStringWriter();

        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put(CREATION_TIME, creationTime);
        velocityContext.put(EXPIRY_TIME, expiryTime);
        velocityContext.put(URI, uri);

        renewSTTemplate.merge(velocityContext, stringWriter);

        return stringWriter.toString();
    }

    /**
     * Build a RST which is required for validating a security token
     * from the Security Token Service.
     *
     * @param creationTime Creation time of the Request Security Token.
     * @param expiryTime   Expiry time of the Request Security Token.
     * @param uri          Identifier for the Security Token to be validated.
     * @return A soap request containing the Request Security Token used
     * to validate a security token.
     */
    public static String buildRSTToValidateSecurityToken(String creationTime, String expiryTime, String uri) {

        initVelocityEngine();
        clearStringWriter();

        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put(CREATION_TIME, creationTime);
        velocityContext.put(EXPIRY_TIME, expiryTime);
        velocityContext.put(URI, uri);

        validateSTTemplate.merge(velocityContext, stringWriter);

        return stringWriter.toString();
    }

    /**
     * Initialize the velocity engine if it is not initialized yet to
     * use functions based on templating.
     */
    private static void initVelocityEngine() {

        if (!isVEInitialized) {

            ClassLoader classLoader = RequestConstructor.class.getClassLoader();
            Properties properties = new Properties();
            String path = new File(classLoader.getResource("templates").getPath()).getAbsolutePath();
            properties.put("file.resource.loader.path", path);

            velocityEngine.init(properties);

            requestSTTemplate = velocityEngine.getTemplate(REQUEST_ST_TEMPLATE);
            renewSTTemplate = velocityEngine.getTemplate(RENEW_ST_TEMPLATE);
            validateSTTemplate = velocityEngine.getTemplate(VALIDATE_ST_TEMPLATE);

            isVEInitialized = true;
        }
    }

    /**
     * Clear the string writer after it has been used previously.
     */
    private static void clearStringWriter() {

        if (stringWriter.getBuffer().length() > 0) {
            stringWriter.getBuffer().setLength(0);
        }
    }
}
