import constants.Constants;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Client {

    public static void main(String[] args) throws SOAPException, IOException {

//        System.setProperty("javax.net.debug", "ssl");
        System.setProperty("javax.net.ssl.trustStore", Constants.TRUST_STORE_LOCATION);
        System.setProperty("javax.net.ssl.trustStorePassword", Constants.TRUST_STORE_PASSWORD);

        InputStream byteArrayInputStream = new ByteArrayInputStream(Constants.request_ST_RST.getBytes());
        SOAPMessage request = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL)
                .createMessage(null, byteArrayInputStream);
        byteArrayInputStream.close();

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
}
