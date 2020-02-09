import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Client {

    private static final String TRUST_STORE_LOCATION = "../src/resources/wso2carbon.jks";
    private static final String TRUST_STORE_PASSWORD = "wso2carbon";
    private static final String STS_ENDPOINT_URL = "https://localhost:9443/services/wso2carbon-sts";

    public static void main(String[] args) throws SOAPException, IOException {

        System.setProperty("javax.net.ssl.trustStore", TRUST_STORE_LOCATION);
        System.setProperty("javax.net.ssl.trustStorePassword", TRUST_STORE_PASSWORD);

        InputStream is = new ByteArrayInputStream(RequestConstants.request_ST_RST.getBytes());
        SOAPMessage request = MessageFactory.newInstance().createMessage(null, is);

        callSoapWebService(STS_ENDPOINT_URL, request);
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
