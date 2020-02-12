package org.wso2.samples.is.sts.wstrust.client;

import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.diff.Diff;
import org.xmlunit.diff.Difference;

import java.io.IOException;
import java.io.InputStream;

import org.wso2.samples.is.sts.wstrust.client.util.TestUtils;

import static org.wso2.samples.is.sts.wstrust.client.constants.TestConstants.CHANGING_XPATHS_FOR_REQUEST_ST_RSTR;
import static org.wso2.samples.is.sts.wstrust.client.constants.TestConstants.NO_OF_DIFFERENCES_FOR_REQUEST_ST_RSTR;

public class RequestSecurityTokenRSTRTest {

    public static void main(String[] args) {

        InputStream inputStream = RequestSecurityTokenRSTRTest.class.getClassLoader().getResourceAsStream("templates/request_security_token_RSTR.xml");

        String templatedRSTR = null;
        try {
            templatedRSTR = TestUtils.convertInputStreamToString(inputStream);
        } catch (IOException exception) {
            System.err.println("An error occurred while retrieving the template from file. Error message: " +  exception.getMessage());
        }
        
        String receivedRSTR = "<soapenv:Envelope xmlns:soapenv=\"http://www.w3.org/2003/05/soap-envelope\"><soapenv:Header xmlns:wsa=\"http://schemas.xmlsoap.org/ws/2004/08/addressing\"><wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" soapenv:mustUnderstand=\"true\"><wsu:Timestamp xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\" wsu:Id=\"Timestamp-1\"><wsu:Created>2020-02-12T07:19:50.903Z</wsu:Created><wsu:Expires>2020-02-12T07:24:50.903Z</wsu:Expires></wsu:Timestamp></wsse:Security><wsa:To>http://schemas.xmlsoap.org/ws/2004/08/addressing/role/anonymous</wsa:To><wsa:MessageID>urn:uuid:38561738-c88b-4f06-9342-9ded42a85861</wsa:MessageID><wsa:Action>http://schemas.xmlsoap.org/ws/2005/02/trust/RSTRC/IssueFinal</wsa:Action><wsa:RelatesTo>urn:uuid:2e7c4171-415c-49c6-bb8a-3bee3f76b48d</wsa:RelatesTo></soapenv:Header><soapenv:Body><wst:RequestSecurityTokenResponse xmlns:wst=\"http://schemas.xmlsoap.org/ws/2005/02/trust\"><wst:TokenType>http://docs.oasis-open.org/wss/oasis-wss-saml-token-profile-1.1#SAMLV2.0</wst:TokenType><wst:RequestedAttachedReference><wsse:SecurityTokenReference xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\"><wsse:Reference URI=\"#urn:uuid:A32C21266985A6F8BF1581491990581\" ValueType=\"http://docs.oasis-open.org/wss/oasis-wss-saml-token-profile-1.1#SAMLV2.0\"/></wsse:SecurityTokenReference></wst:RequestedAttachedReference><wst:RequestedUnattachedReference><wsse:SecurityTokenReference xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\"><wsse:Reference URI=\"urn:uuid:A32C21266985A6F8BF1581491990581\" ValueType=\"http://docs.oasis-open.org/wss/oasis-wss-saml-token-profile-1.1#SAMLV2.0\"/></wsse:SecurityTokenReference></wst:RequestedUnattachedReference><wsp:AppliesTo xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><wsa:EndpointReference xmlns:wsa=\"http://schemas.xmlsoap.org/ws/2004/08/addressing\"><wsa:Address>https://localhost:10443/services/echo</wsa:Address></wsa:EndpointReference></wsp:AppliesTo><wst:Lifetime><wsu:Created xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">2020-02-12T07:19:50.586Z</wsu:Created><wsu:Expires xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">2020-02-12T07:24:50.586Z</wsu:Expires></wst:Lifetime><wst:RequestedSecurityToken><saml2:Assertion xmlns:saml2=\"urn:oasis:names:tc:SAML:2.0:assertion\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" ID=\"urn:uuid:A32C21266985A6F8BF1581491990581\" IssueInstant=\"2020-02-12T07:19:50.636Z\" Version=\"2.0\"><saml2:Issuer>https://localhost</saml2:Issuer><ds:Signature xmlns:ds=\"http://www.w3.org/2000/09/xmldsig#\">\n" +
                "<ds:SignedInfo>\n" +
                "<ds:CanonicalizationMethod Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\"/>\n" +
                "<ds:SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/>\n" +
                "<ds:Reference URI=\"#urn:uuid:A32C21266985A6F8BF1581491990581\">\n" +
                "<ds:Transforms>\n" +
                "<ds:Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/>\n" +
                "<ds:Transform Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\"><ec:InclusiveNamespaces xmlns:ec=\"http://www.w3.org/2001/10/xml-exc-c14n#\" PrefixList=\"xs\"/></ds:Transform>\n" +
                "</ds:Transforms>\n" +
                "<ds:DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/>\n" +
                "<ds:DigestValue>gPkXZ5sYvCMjFQhKCaB8Sa6Ncz8=</ds:DigestValue>\n" +
                "</ds:Reference>\n" +
                "</ds:SignedInfo>\n" +
                "<ds:SignatureValue>\n" +
                "bl8h4l86Lfb9bh1y+g74Ra53aeS5mwEcspWIesc2pGrkvP6n1GmS9nBxr94FKo3gPhoQaaKhv6fg\n" +
                "nEparE3dG0c6Kg/Q03Pw0aEMVTnTOstBsP7g9HFl+u8ptHuFckASTgEAATLn9RnQx7nqCJjBaTpj\n" +
                "huZOix2PCPXPL/CI50zeOc5VzAA91O9UzZ27bdlr/QUYI8xIXKtmkV6n45hNlB1zA4KYJDC02Cni\n" +
                "A56OWiko0UIgO6vPYXbnD1POJ5SZcDcUQWRP6aQ/rm4LN3+7VSpsEqyfBUKeZlnAzkdNdG+/sALJ\n" +
                "wNwFt4RvD3fVwUz3BTFmgaNMgDA7HmaxFkWlig==\n" +
                "</ds:SignatureValue>\n" +
                "<ds:KeyInfo><ds:X509Data><ds:X509Certificate>MIIDqTCCApGgAwIBAgIEXbABozANBgkqhkiG9w0BAQsFADBkMQswCQYDVQQGEwJVUzELMAkGA1UE\n" +
                "CAwCQ0ExFjAUBgNVBAcMDU1vdW50YWluIFZpZXcxDTALBgNVBAoMBFdTTzIxDTALBgNVBAsMBFdT\n" +
                "TzIxEjAQBgNVBAMMCWxvY2FsaG9zdDAeFw0xOTEwMjMwNzMwNDNaFw0yMjAxMjUwNzMwNDNaMGQx\n" +
                "CzAJBgNVBAYTAlVTMQswCQYDVQQIDAJDQTEWMBQGA1UEBwwNTW91bnRhaW4gVmlldzENMAsGA1UE\n" +
                "CgwEV1NPMjENMAsGA1UECwwEV1NPMjESMBAGA1UEAwwJbG9jYWxob3N0MIIBIjANBgkqhkiG9w0B\n" +
                "AQEFAAOCAQ8AMIIBCgKCAQEAxeqoZYbQ/Sr8DOFQ+/qbEbCp6Vzb5hzH7oa3hf2FZxRKF0H6b8CO\n" +
                "Mzz8+0mvEdYVvb/31jMEL2CIQhkQRol1IruD6nBOmkjuXJSBficklMaJZORhuCrB4roHxzoG19aW\n" +
                "mscA0gnfBKo2oGXSjJmnZxIh+2X6syHCfyMZZ00LzDyrgoXWQXyFvCA2ax54s7sKiHOM3P4A9W4Q\n" +
                "UwmoEi4HQmPgJjIM4eGVPh0GtIANN+BOQ1KkUI7OzteHCTLu3VjxM0sw8QRayZdhniPF+U9n3fa1\n" +
                "mO4KLBsW4mDLjg8R/JuAGTX/SEEGj0B5HWQAP6myxKFz2xwDaCGvT+rdvkktOwIDAQABo2MwYTAU\n" +
                "BgNVHREEDTALgglsb2NhbGhvc3QwHQYDVR0OBBYEFEDpLB4PDgzsdxD2FV3rVnOr/A0DMB0GA1Ud\n" +
                "JQQWMBQGCCsGAQUFBwMBBggrBgEFBQcDAjALBgNVHQ8EBAMCBPAwDQYJKoZIhvcNAQELBQADggEB\n" +
                "AE8H/axAgXjt93HGCYGumULW2lKkgqEvXryP2QkRpbyQSsTYcL7ZLSVB7MVVHtIsHh8f1C4Xq6Qu\n" +
                "8NUrqu5ZLC1pUByaqR2ZIzcj/OWLGYRjSTHSVmVIq9QqBq1j7r6f3BWqaOIiknmTzEuqIVlOTY0g\n" +
                "O+SHdS62vr2FCz4yOrBEulGAvomsU8sqg4PhFnkhxI4M912Ly+2RgN9L7AkhzK+EzXY1/QtlI/Vy\n" +
                "sNfS6zrHasKz6CrKKCGqQnBnSvSTyF9OR5KFHnkAwE995IZrcSQicMxsLhTMUHDLQ/gRyy7V/ZpD\n" +
                "MfAWR+5OeQiNAp/bG4fjJoTdoqkul51+2bHHVrU=</ds:X509Certificate></ds:X509Data></ds:KeyInfo></ds:Signature><saml2:Subject><saml2:NameID Format=\"urn:oasis:names:tc:SAML:1.1:nameid-format:emailAddress\">admin</saml2:NameID><saml2:SubjectConfirmation Method=\"urn:oasis:names:tc:SAML:2.0:cm:bearer\"/></saml2:Subject><saml2:Conditions NotBefore=\"2020-02-12T07:19:50.586Z\" NotOnOrAfter=\"2020-02-12T07:24:50.586Z\"><saml2:AudienceRestriction><saml2:Audience>https://localhost:10443/services/echo</saml2:Audience></saml2:AudienceRestriction></saml2:Conditions><saml2:AttributeStatement><saml2:Attribute Name=\"http://wso2.org/claims/emailaddress\" NameFormat=\"http://wso2.org/claims/emailaddress\"><saml2:AttributeValue xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"xs:string\">admin@wso2.com</saml2:AttributeValue></saml2:Attribute></saml2:AttributeStatement><saml2:AuthnStatement AuthnInstant=\"2020-02-12T07:19:50.723Z\"><saml2:AuthnContext><saml2:AuthnContextClassRef>urn:oasis:names:tc:SAML:2.0:ac:classes:Password</saml2:AuthnContextClassRef></saml2:AuthnContext></saml2:AuthnStatement></saml2:Assertion></wst:RequestedSecurityToken></wst:RequestSecurityTokenResponse></soapenv:Body></soapenv:Envelope>\n";

        Diff diff = DiffBuilder.compare(templatedRSTR).ignoreWhitespace().withTest(receivedRSTR).ignoreWhitespace()
                .checkForSimilar().build();

        int count = 0;

        for (Difference difference : diff.getDifferences()) {
            String xPath = difference.getComparison().getTestDetails().getXPath();
            System.out.println(difference.getComparison().getTestDetails().getParentXPath());
            System.out.println("Expected change: " + xPath.equals(CHANGING_XPATHS_FOR_REQUEST_ST_RSTR.get(count)));
            System.out.println();
            count++;
        }

        System.out.println("Expected differences are met: " + Boolean.valueOf(count == NO_OF_DIFFERENCES_FOR_REQUEST_ST_RSTR).toString());
    }
}
