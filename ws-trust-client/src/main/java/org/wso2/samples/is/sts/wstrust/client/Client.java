package org.wso2.samples.is.sts.wstrust.client;

import org.wso2.samples.is.sts.wstrust.client.exception.WSTrustClientException;
import org.wso2.samples.is.sts.wstrust.client.util.ClientUtils;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import java.io.IOException;

import static org.wso2.samples.is.sts.wstrust.client.constants.Constants.ACTION_RENEW;
import static org.wso2.samples.is.sts.wstrust.client.constants.Constants.ACTION_REQUEST;
import static org.wso2.samples.is.sts.wstrust.client.constants.Constants.ACTION_VALIDATE;
import static org.wso2.samples.is.sts.wstrust.client.constants.Constants.GREEN_COLOR;
import static org.wso2.samples.is.sts.wstrust.client.constants.Constants.RESET_COLOR;

public class Client {
    public static void main(String[] args) {

        SOAPMessage[] requestSTRequestAndResponse;
        SOAPMessage[] renewSTRequestAndResponse;
        SOAPMessage[] validateSTRequestAndResponse;

        try {
            requestSTRequestAndResponse = ClientUtils.callSoapWebService(ACTION_REQUEST);
            System.out.println(GREEN_COLOR + "Issue Security Token RST: " + RESET_COLOR);
            requestSTRequestAndResponse[0].writeTo(System.out);
            System.out.println("\n\n");

            System.out.println(GREEN_COLOR + "Issued Security Token RSTR: " + RESET_COLOR);
            requestSTRequestAndResponse[1].writeTo(System.out);
            System.out.println("\n\n");

            String uri = requestSTRequestAndResponse[1].getSOAPBody().getElementsByTagName("wsse:Reference").item(0).getAttributes().getNamedItem("URI").getNodeValue();
            uri = uri.substring(1);

            renewSTRequestAndResponse = ClientUtils.callSoapWebService(ACTION_RENEW, uri);
            System.out.println(GREEN_COLOR + "Renew Security Token RST: " + RESET_COLOR);
            renewSTRequestAndResponse[0].writeTo(System.out);
            System.out.println("\n\n");

            System.out.println(GREEN_COLOR + "Renewed Security Token RSTR: " + RESET_COLOR);
            renewSTRequestAndResponse[1].writeTo(System.out);
            System.out.println("\n\n");

            validateSTRequestAndResponse = ClientUtils.callSoapWebService(ACTION_VALIDATE, uri);
            System.out.println(GREEN_COLOR + "Validate Security Token RST: " + RESET_COLOR);
            validateSTRequestAndResponse[0].writeTo(System.out);
            System.out.println("\n\n");

            System.out.println(GREEN_COLOR + "Validate Security Token RSTR: " + RESET_COLOR);
            validateSTRequestAndResponse[1].writeTo(System.out);
            System.out.println("\n\n");

        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WSTrustClientException e) {
            e.printStackTrace();
        }

    }
}
