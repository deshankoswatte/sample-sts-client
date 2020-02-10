import exception.WSTrustClientException;
import util.ClientUtils;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import java.io.IOException;

import static constants.Constants.ACTION_RENEW;
import static constants.Constants.ACTION_REQUEST;
import static constants.Constants.ACTION_VALIDATE;

public class Client2 {
    public static void main(String[] args) {

        SOAPMessage request_ST_RSTR;
        SOAPMessage renew_ST_RSTR;
        SOAPMessage validate_ST_RSTR;

        try {
            request_ST_RSTR = ClientUtils.callSoapWebService(ACTION_REQUEST);
            System.out.println("Issued Security Token RSTR: ");
            request_ST_RSTR.writeTo(System.out);
            System.out.println("\n\n\n\n\n");

            String uri = request_ST_RSTR.getSOAPBody().getElementsByTagName("wsse:Reference").item(0).getAttributes().getNamedItem("URI").getNodeValue();
            uri = uri.substring(1);

            renew_ST_RSTR = ClientUtils.callSoapWebService(ACTION_RENEW, uri);
            System.out.println("Renewed Security Token RSTR: ");
            renew_ST_RSTR.writeTo(System.out);
            System.out.println("\n\n\n\n\n");

            System.out.println("Validate Security Token RSTR: ");
            validate_ST_RSTR = ClientUtils.callSoapWebService(ACTION_VALIDATE, uri);
            validate_ST_RSTR.writeTo(System.out);

        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WSTrustClientException e) {
            e.printStackTrace();
        }


    }
}
