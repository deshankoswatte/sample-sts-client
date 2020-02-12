package org.wso2.samples.is.sts.wstrust.client;

import org.wso2.samples.is.sts.wstrust.client.util.ClientUtils;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.builder.Input;
import org.xmlunit.diff.Diff;
import org.xmlunit.diff.Difference;

import java.io.File;

public class RequestSecurityTokenRSTRTest {

    public static void main(String[] args) {

        ClassLoader classLoader = ClientUtils.class.getClassLoader();
        String testPath = "<soapenv:Envelope xmlns:soapenv=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "    <soapenv:Header xmlns:wsa=\"http://schemas.xmlsoap.org/ws/2004/08/addressing\">\n" +
                "        <wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\"\n" +
                "                       soapenv:mustUnderstand=\"true\">\n" +
                "            <wsu:Timestamp\n" +
                "                    xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"\n" +
                "                    wsu:Id=\"Timestamp-10\">\n" +
                "                <wsu:Created>2020-02-07T04:45:02.146Z</wsu:Created>\n" +
                "                <wsu:Expires>2020-02-07T04:50:02.146Z</wsu:Expires>\n" +
                "            </wsu:Timestamp>\n" +
                "        </wsse:Security>\n" +
                "        <wsa:To>http://schemas.xmlsoap.org/ws/2004/08/addressing/role/anonymous</wsa:To>\n" +
                "        <wsa:MessageID>urn:uuid:0e04db89-c8da-465e-8e14-56f58660f7bd</wsa:MessageID>\n" +
                "        <wsa:Action>http://schemas.xmlsoap.org/ws/2005/02/trust/RSTRC/IssueFinal</wsa:Action>\n" +
                "        <wsa:RelatesTo>urn:uuid:2e7c4171-415c-49c6-bb8a-3bee3f76b48d</wsa:RelatesTo>\n" +
                "    </soapenv:Header>\n" +
                "    <soapenv:Body>\n" +
                "        <wst:RequestSecurityTokenResponse xmlns:wst=\"http://schemas.xmlsoap.org/ws/2005/02/trust\">\n" +
                "            <wst:TokenType>http://docs.oasis-open.org/wss/oasis-wss-saml-token-profile-1.1#SAMLV2.0</wst:TokenType>\n" +
                "            <wst:RequestedAttachedReference>\n" +
                "                <wsse:SecurityTokenReference\n" +
                "                        xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">\n" +
                "                    <wsse:Reference URI=\"#urn:uuid:A5571AE6A8827AE3841581050702133\"\n" +
                "                                    ValueType=\"http://docs.oasis-open.org/wss/oasis-wss-saml-token-profile-1.1#SAMLV2.0\"/>\n" +
                "                </wsse:SecurityTokenReference>\n" +
                "            </wst:RequestedAttachedReference>\n" +
                "            <wst:RequestedUnattachedReference>\n" +
                "                <wsse:SecurityTokenReference\n" +
                "                        xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">\n" +
                "                    <wsse:Reference URI=\"urn:uuid:A5571AE6A8827AE3841581050702133\"\n" +
                "                                    ValueType=\"http://docs.oasis-open.org/wss/oasis-wss-saml-token-profile-1.1#SAMLV2.0\"/>\n" +
                "                </wsse:SecurityTokenReference>\n" +
                "            </wst:RequestedUnattachedReference>\n" +
                "            <wsp:AppliesTo xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\">\n" +
                "                <wsa:EndpointReference xmlns:wsa=\"http://schemas.xmlsoap.org/ws/2004/08/addressing\">\n" +
                "                    <wsa:Address>https://localhost:10443/services/echo</wsa:Address>\n" +
                "                </wsa:EndpointReference>\n" +
                "            </wsp:AppliesTo>\n" +
                "            <wst:Lifetime>\n" +
                "                <wsu:Created\n" +
                "                        xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                "                    2020-02-07T04:45:02.129Z\n" +
                "                </wsu:Created>\n" +
                "                <wsu:Expires\n" +
                "                        xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                "                    2020-02-07T04:50:02.129Z\n" +
                "                </wsu:Expires>\n" +
                "            </wst:Lifetime>\n" +
                "            <wst:RequestedSecurityToken>\n" +
                "                <saml2:Assertion xmlns:saml2=\"urn:oasis:names:tc:SAML:2.0:assertion\"\n" +
                "                                 xmlns:xs=\"http://www.w3.org/2001/XMLSchema\"\n" +
                "                                 ID=\"urn:uuid:A5571AE6A8827AE3841581050702133\" IssueInstant=\"2020-02-07T04:45:02.129Z\"\n" +
                "                                 Version=\"2.0\">\n" +
                "                    <saml2:Issuer>https://localhost</saml2:Issuer>\n" +
                "                    <ds:Signature xmlns:ds=\"http://www.w3.org/2000/09/xmldsig#\">\n" +
                "                        <ds:SignedInfo>\n" +
                "                            <ds:CanonicalizationMethod Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\"/>\n" +
                "                            <ds:SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/>\n" +
                "                            <ds:Reference URI=\"#urn:uuid:A5571AE6A8827AE3841581050702133\">\n" +
                "                                <ds:Transforms>\n" +
                "                                    <ds:Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/>\n" +
                "                                    <ds:Transform Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\">\n" +
                "                                        <ec:InclusiveNamespaces xmlns:ec=\"http://www.w3.org/2001/10/xml-exc-c14n#\"\n" +
                "                                                                PrefixList=\"xs\"/>\n" +
                "                                    </ds:Transform>\n" +
                "                                </ds:Transforms>\n" +
                "                                <ds:DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/>\n" +
                "                                <ds:DigestValue>ZVmrhv8HvbpHI0udpkXQphai4P0=</ds:DigestValue>\n" +
                "                            </ds:Reference>\n" +
                "                        </ds:SignedInfo>\n" +
                "                        <ds:SignatureValue>\n" +
                "                            FZAERI4DKOMWE6yssOK/LmYyU/YD2wJRi40sAANoXYGRIXJcRaGDSE40N++3bAZtl4YkxXaCQBJlYbIsQiy4wJIfEhQzvzsZv6cCIf/cPPXvY9hQjslcoFaj4uAGqE0k1DiLUWxvAQ34YLCL5zyKZv9OPJFQMlBizEvmkbn4ZZV365VI+d67jmBcEuSZRhgWFkZuE/RbJfir45FwWCNUMpAzjC4XU5pGQCNyZ3UvV+ikn5wYkYkvvL8z6z002pvkWs02qLmHm/gtSFcpsgODzSihsT8c3gNgdyYKCFcvkvKTQifNF0lqN/c8ozjlwCV26mtcewXiqP0aMi2ie6xWRg==\n" +
                "                        </ds:SignatureValue>\n" +
                "                        <ds:KeyInfo>\n" +
                "                            <ds:X509Data>\n" +
                "                                <ds:X509Certificate>\n" +
                "                                    MIIDqTCCApGgAwIBAgIEXbABozANBgkqhkiG9w0BAQsFADBkMQswCQYDVQQGEwJVUzELMAkGA1UECAwCQ0ExFjAUBgNVBAcMDU1vdW50YWluIFZpZXcxDTALBgNVBAoMBFdTTzIxDTALBgNVBAsMBFdTTzIxEjAQBgNVBAMMCWxvY2FsaG9zdDAeFw0xOTEwMjMwNzMwNDNaFw0yMjAxMjUwNzMwNDNaMGQxCzAJBgNVBAYTAlVTMQswCQYDVQQIDAJDQTEWMBQGA1UEBwwNTW91bnRhaW4gVmlldzENMAsGA1UECgwEV1NPMjENMAsGA1UECwwEV1NPMjESMBAGA1UEAwwJbG9jYWxob3N0MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxeqoZYbQ/Sr8DOFQ+/qbEbCp6Vzb5hzH7oa3hf2FZxRKF0H6b8COMzz8+0mvEdYVvb/31jMEL2CIQhkQRol1IruD6nBOmkjuXJSBficklMaJZORhuCrB4roHxzoG19aWmscA0gnfBKo2oGXSjJmnZxIh+2X6syHCfyMZZ00LzDyrgoXWQXyFvCA2ax54s7sKiHOM3P4A9W4QUwmoEi4HQmPgJjIM4eGVPh0GtIANN+BOQ1KkUI7OzteHCTLu3VjxM0sw8QRayZdhniPF+U9n3fa1mO4KLBsW4mDLjg8R/JuAGTX/SEEGj0B5HWQAP6myxKFz2xwDaCGvT+rdvkktOwIDAQABo2MwYTAUBgNVHREEDTALgglsb2NhbGhvc3QwHQYDVR0OBBYEFEDpLB4PDgzsdxD2FV3rVnOr/A0DMB0GA1UdJQQWMBQGCCsGAQUFBwMBBggrBgEFBQcDAjALBgNVHQ8EBAMCBPAwDQYJKoZIhvcNAQELBQADggEBAE8H/axAgXjt93HGCYGumULW2lKkgqEvXryP2QkRpbyQSsTYcL7ZLSVB7MVVHtIsHh8f1C4Xq6Qu8NUrqu5ZLC1pUByaqR2ZIzcj/OWLGYRjSTHSVmVIq9QqBq1j7r6f3BWqaOIiknmTzEuqIVlOTY0gO+SHdS62vr2FCz4yOrBEulGAvomsU8sqg4PhFnkhxI4M912Ly+2RgN9L7AkhzK+EzXY1/QtlI/VysNfS6zrHasKz6CrKKCGqQnBnSvSTyF9OR5KFHnkAwE995IZrcSQicMxsLhTMUHDLQ/gRyy7V/ZpDMfAWR+5OeQiNAp/bG4fjJoTdoqkul51+2bHHVrU=\n" +
                "                                </ds:X509Certificate>\n" +
                "                            </ds:X509Data>\n" +
                "                        </ds:KeyInfo>\n" +
                "                    </ds:Signature>\n" +
                "                    <saml2:Subject>\n" +
                "                        <saml2:NameID Format=\"urn:oasis:names:tc:SAML:1.1:nameid-format:emailAddress\">admin\n" +
                "                        </saml2:NameID>\n" +
                "                        <saml2:SubjectConfirmation Method=\"urn:oasis:names:tc:SAML:2.0:cm:bearer\"/>\n" +
                "                    </saml2:Subject>\n" +
                "                    <saml2:Conditions NotBefore=\"2020-02-07T04:45:02.129Z\" NotOnOrAfter=\"2020-02-07T04:50:02.129Z\">\n" +
                "                        <saml2:AudienceRestriction>\n" +
                "                            <saml2:Audience>https://localhost:10443/services/echo</saml2:Audience>\n" +
                "                        </saml2:AudienceRestriction>\n" +
                "                    </saml2:Conditions>\n" +
                "                    <saml2:AttributeStatement>\n" +
                "                        <saml2:Attribute Name=\"http://wso2.org/claims/emailaddress\"\n" +
                "                                         NameFormat=\"http://wso2.org/claims/emailaddress\">\n" +
                "                            <saml2:AttributeValue xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                "                                                  xsi:type=\"xs:string\">admin@wso2.com\n" +
                "                            </saml2:AttributeValue>\n" +
                "                        </saml2:Attribute>\n" +
                "                    </saml2:AttributeStatement>\n" +
                "                    <saml2:AuthnStatement AuthnInstant=\"2020-02-07T04:45:02.140Z\">\n" +
                "                        <saml2:AuthnContext>\n" +
                "                            <saml2:AuthnContextClassRef>urn:oasis:names:tc:SAML:2.0:ac:classes:Password\n" +
                "                            </saml2:AuthnContextClassRef>\n" +
                "                        </saml2:AuthnContext>\n" +
                "                    </saml2:AuthnStatement>\n" +
                "                </saml2:Assertion>\n" +
                "            </wst:RequestedSecurityToken>\n" +
                "        </wst:RequestSecurityTokenResponse>\n" +
                "    </soapenv:Body>\n" +
                "</soapenv:Envelope>\n";
        String controlPath = "<soapenv:Envelope xmlns:soapenv=\"http://www.w3.org/2003/05/soap-envelope\"><soapenv:Header xmlns:wsa=\"http://schemas.xmlsoap.org/ws/2004/08/addressing\"><wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" soapenv:mustUnderstand=\"true\"><wsu:Timestamp xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\" wsu:Id=\"Timestamp-1\"><wsu:Created>2020-02-11T14:34:28.400Z</wsu:Created><wsu:Expires>2020-02-11T14:39:28.400Z</wsu:Expires></wsu:Timestamp></wsse:Security><wsa:To>http://schemas.xmlsoap.org/ws/2004/08/addressing/role/anonymous</wsa:To><wsa:MessageID>urn:uuid:6c02b8a1-d667-41f5-a298-04262c282e6d</wsa:MessageID><wsa:Action>http://schemas.xmlsoap.org/ws/2005/02/trust/RSTRC/IssueFinal</wsa:Action><wsa:RelatesTo>urn:uuid:2e7c4171-415c-49c6-bb8a-3bee3f76b48d</wsa:RelatesTo></soapenv:Header><soapenv:Body><wst:RequestSecurityTokenResponse xmlns:wst=\"http://schemas.xmlsoap.org/ws/2005/02/trust\"><wst:TokenType>http://docs.oasis-open.org/wss/oasis-wss-saml-token-profile-1.1#SAMLV2.0</wst:TokenType><wst:RequestedAttachedReference><wsse:SecurityTokenReference xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\"><wsse:Reference URI=\"#urn:uuid:EA7522E22FAAB1E9D11581431668103\" ValueType=\"http://docs.oasis-open.org/wss/oasis-wss-saml-token-profile-1.1#SAMLV2.0\"/></wsse:SecurityTokenReference></wst:RequestedAttachedReference><wst:RequestedUnattachedReference><wsse:SecurityTokenReference xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\"><wsse:Reference URI=\"urn:uuid:EA7522E22FAAB1E9D11581431668103\" ValueType=\"http://docs.oasis-open.org/wss/oasis-wss-saml-token-profile-1.1#SAMLV2.0\"/></wsse:SecurityTokenReference></wst:RequestedUnattachedReference><wsp:AppliesTo xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><wsa:EndpointReference xmlns:wsa=\"http://schemas.xmlsoap.org/ws/2004/08/addressing\"><wsa:Address>https://localhost:10443/services/echo</wsa:Address></wsa:EndpointReference></wsp:AppliesTo><wst:Lifetime><wsu:Created xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">2020-02-11T14:34:28.108Z</wsu:Created><wsu:Expires xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">2020-02-11T14:39:28.108Z</wsu:Expires></wst:Lifetime><wst:RequestedSecurityToken><saml2:Assertion xmlns:saml2=\"urn:oasis:names:tc:SAML:2.0:assertion\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" ID=\"urn:uuid:EA7522E22FAAB1E9D11581431668103\" IssueInstant=\"2020-02-11T14:34:28.133Z\" Version=\"2.0\"><saml2:Issuer>https://localhost</saml2:Issuer><ds:Signature xmlns:ds=\"http://www.w3.org/2000/09/xmldsig#\">\n" +
                "<ds:SignedInfo>\n" +
                "<ds:CanonicalizationMethod Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\"/>\n" +
                "<ds:SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/>\n" +
                "<ds:Reference URI=\"#urn:uuid:EA7522E22FAAB1E9D11581431668103\">\n" +
                "<ds:Transforms>\n" +
                "<ds:Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/>\n" +
                "<ds:Transform Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\"><ec:InclusiveNamespaces xmlns:ec=\"http://www.w3.org/2001/10/xml-exc-c14n#\" PrefixList=\"xs\"/></ds:Transform>\n" +
                "</ds:Transforms>\n" +
                "<ds:DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/>\n" +
                "<ds:DigestValue>KBJPmBGo/fnMjwk2v5+TAKzKLDM=</ds:DigestValue>\n" +
                "</ds:Reference>\n" +
                "</ds:SignedInfo>\n" +
                "<ds:SignatureValue>\n" +
                "MjGkkfFKkODXswXBSMhlRg/e8pkG+rqgwor18RIsh+CYvkbJOe5I4glv3Mv1F9igE2Fa8yqeywBL\n" +
                "qk5WkMdI2q2y0RagePtLRDRgFU+pKVem9B83UBKM+8NDFlnXGh+xsZK+G81Uewo3+LUkPDiKJAX8\n" +
                "k5y2bCsP1hAgc6aXUNhAaGMImCIuXuMwMe9D4okldcQgYHUSe9tWcHRwqhpkwOVibUi25u9c7EpJ\n" +
                "+bEjzgmlp6Izj+sMB+7prOYVKvhxeDcASVlCG5eKrAlyoTXdQqpmkFkRuvIg0RtU9fXOGDYh0uVc\n" +
                "HZD/at0Xvn/39jya0e+bD350Vi/hihQEQYPUtg==\n" +
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
                "MfAWR+5OeQiNAp/bG4fjJoTdoqkul51+2bHHVrU=</ds:X509Certificate></ds:X509Data></ds:KeyInfo></ds:Signature><saml2:Subject><saml2:NameID Format=\"urn:oasis:names:tc:SAML:1.1:nameid-format:emailAddress\">admin</saml2:NameID><saml2:SubjectConfirmation Method=\"urn:oasis:names:tc:SAML:2.0:cm:bearer\"/></saml2:Subject><saml2:Conditions NotBefore=\"2020-02-11T14:34:28.108Z\" NotOnOrAfter=\"2020-02-11T14:39:28.108Z\"><saml2:AudienceRestriction><saml2:Audience>https://localhost:10443/services/echo</saml2:Audience></saml2:AudienceRestriction></saml2:Conditions><saml2:AttributeStatement><saml2:Attribute Name=\"http://wso2.org/claims/emailaddress\" NameFormat=\"http://wso2.org/claims/emailaddress\"><saml2:AttributeValue xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"xs:string\">admin@wso2.com</saml2:AttributeValue></saml2:Attribute></saml2:AttributeStatement><saml2:AuthnStatement AuthnInstant=\"2020-02-11T14:34:28.226Z\"><saml2:AuthnContext><saml2:AuthnContextClassRef>urn:oasis:names:tc:SAML:2.0:ac:classes:Password</saml2:AuthnContextClassRef></saml2:AuthnContext></saml2:AuthnStatement></saml2:Assertion></wst:RequestedSecurityToken></wst:RequestSecurityTokenResponse></soapenv:Body></soapenv:Envelope>\n";

        Diff diff = DiffBuilder.compare(controlPath).ignoreWhitespace().withTest(testPath).ignoreWhitespace()
                .checkForSimilar().build();

//        System.out.println(diff.toString());
        for (Difference difference : diff.getDifferences()) {
            System.out.println(difference.getComparison());
            System.out.println();
        }
    }
}
