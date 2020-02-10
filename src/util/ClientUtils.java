package util;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import constants.Requests;
import exception.WSTrustClientException;

import static constants.Constants.ACTION_RENEW;
import static constants.Constants.ACTION_REQUEST;
import static constants.Constants.ACTION_VALIDATE;
import static constants.Constants.STS_ENDPOINT_URL;
import static constants.Constants.TRUST_STORE_LOCATION;
import static constants.Constants.TRUST_STORE_PASSWORD;

public class ClientUtils {

    public static SOAPMessage callSoapWebService(String action, String... parameters)
            throws WSTrustClientException {

        setSystemProperties();

        SOAPMessage soapRequest;
        SOAPMessage soapResponse;

        try {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            if (action.equals(ACTION_REQUEST)) {
                soapRequest = buildRequest(action);
            } else if (action.equals(ACTION_RENEW) && parameters.length > 0) {
                soapRequest = buildRequest(action, parameters[0]);
            } else if (action.equals(ACTION_VALIDATE) && parameters.length > 0) {
                soapRequest = buildRequest(action, parameters[0]);
            } else {
                throw new WSTrustClientException("Invalid action parameter passed.");
            }

            soapResponse = soapConnection.call(soapRequest, STS_ENDPOINT_URL);

            soapConnection.close();
        } catch (Exception e) {
            throw new WSTrustClientException("An error occurred while sending SOAP Request to " +
                    "Server. Make sure you have the correct SOAPAction", e);
        }

        return soapResponse;
    }

    private static SOAPMessage buildRequest(String parameter, String... additionalParameters)
            throws IOException, SOAPException, WSTrustClientException {

        SOAPMessage request;
        InputStream byteArrayInputStream;
        String[] timeStamps = generateNewTimeStamps();

        switch (parameter) {

            case ACTION_REQUEST:
                byteArrayInputStream = new ByteArrayInputStream(Requests
                        .buildRSTToRequestSecurityToken(timeStamps[0], timeStamps[1]).getBytes());
                break;

            case ACTION_RENEW:
                byteArrayInputStream = new ByteArrayInputStream(Requests
                        .buildRSTToRenewSecurityToken(timeStamps[0], timeStamps[1], additionalParameters[0]).getBytes());
                break;

            case ACTION_VALIDATE:
                byteArrayInputStream = new ByteArrayInputStream(Requests
                        .buildRSTToValidateSecurityToken(timeStamps[0], timeStamps[1], additionalParameters[0]).getBytes());
                break;

            default:
                throw new WSTrustClientException("Operations of type: Request, Renew and Validate are allowed.");
        }

        request = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL)
                .createMessage(null, byteArrayInputStream);
        byteArrayInputStream.close();

        return request;
    }

    private static void setSystemProperties() {

//        Enable this property to debug ssl related problems
//        System.setProperty("javax.net.debug", "ssl");
        System.setProperty("javax.net.ssl.trustStore", TRUST_STORE_LOCATION);
        System.setProperty("javax.net.ssl.trustStorePassword", TRUST_STORE_PASSWORD);
    }

    private static String[] generateNewTimeStamps() {

        String[] timeStamps = new String[2];

        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        dateFormat.setTimeZone(timeZone);

        Calendar calendar = Calendar.getInstance();
        timeStamps[0] = dateFormat.format(calendar.getTime());
        calendar.add(Calendar.MINUTE, 5);
        timeStamps[1] = dateFormat.format(calendar.getTime());

        return timeStamps;
    }
}
