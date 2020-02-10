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

import constants.Constants;
import constants.Requests;

public class Client {

    public static void main(String[] args) {

        // Enable this property to debug ssl related problems
//        System.setProperty("javax.net.debug", "ssl");
        System.setProperty("javax.net.ssl.trustStore", Constants.TRUST_STORE_LOCATION);
        System.setProperty("javax.net.ssl.trustStorePassword", Constants.TRUST_STORE_PASSWORD);

        SOAPMessage request = null;
        try {
            request = buildRequest();
        } catch (IOException e) {
            System.out.println("Error while creating the SOAP Message. The input " +
                    "stream passed was unreadable: " + e.getMessage());
        } catch (SOAPException e) {
            System.out.println("Error while creating the SOAP Message. Error in creating " +
                    "the specified implementation of Message Factory: " + e.getMessage());
        }

        callSoapWebService(Constants.STS_ENDPOINT_URL, request);
    }

    private static void callSoapWebService(String soapEndpointUrl, SOAPMessage soapMessage) {

        try {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            SOAPMessage soapResponse = soapConnection.call(soapMessage, soapEndpointUrl);

            // Print the SOAP Response
            System.out.println("Response SOAP Message:");
            soapResponse.writeTo(System.out);
            System.out.println();

            soapConnection.close();
        } catch (Exception e) {
            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
            e.printStackTrace();
        }
    }

    private static SOAPMessage buildRequest() throws IOException, SOAPException {

        String[] timeStamps = generateNewTimeStamps();

        System.out.println(Requests.buildRSTToRequestSecurityToken(timeStamps[0], timeStamps[1]));
        InputStream byteArrayInputStream = new ByteArrayInputStream(Requests
                .buildRSTToRequestSecurityToken(timeStamps[0], timeStamps[1]).getBytes());
        SOAPMessage request = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL)
                .createMessage(null, byteArrayInputStream);
        byteArrayInputStream.close();

        return request;
    }

    private static String[] generateNewTimeStamps() {

        String[] timeStamps = new String[2];

        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        dateFormat.setTimeZone(timeZone);

        Calendar calendar = Calendar.getInstance();
        timeStamps[0] = dateFormat.format(calendar.getTime());
        calendar.add(Calendar.MINUTE, 5);
        timeStamps[1]= dateFormat.format(calendar.getTime());

        return timeStamps;
    }
}
