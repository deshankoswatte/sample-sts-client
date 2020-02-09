public class Constants {

    public static String request_ST_RST = "<soapenv:Envelope xmlns:soapenv=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
            "   <soapenv:Header xmlns:wsa=\"http://schemas.xmlsoap.org/ws/2004/08/addressing\">\n" +
            "      <wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" soapenv:mustUnderstand=\"true\">\n" +
            "         <wsu:Timestamp xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\" wsu:Id=\"Timestamp-1\">\n" +
            "            <wsu:Created>2020-02-08T04:45:01.868Z</wsu:Created>\n" +
            "            <wsu:Expires>2020-02-09T04:50:01.868Z</wsu:Expires>\n" +
            "         </wsu:Timestamp>\n" +
            "         <wsse:UsernameToken xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\" wsu:Id=\"UsernameToken-2\">\n" +
            "            <wsse:Username>admin</wsse:Username>\n" +
            "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">admin</wsse:Password>\n" +
            "         </wsse:UsernameToken>\n" +
            "      </wsse:Security>\n" +
            "      <wsa:To>https://localhost:9443/services/wso2carbon-sts</wsa:To>\n" +
            "      <wsa:ReplyTo>\n" +
            "         <wsa:Address>http://schemas.xmlsoap.org/ws/2004/08/addressing/role/anonymous</wsa:Address>\n" +
            "      </wsa:ReplyTo>\n" +
            "      <wsa:MessageID>urn:uuid:2e7c4171-415c-49c6-bb8a-3bee3f76b48d</wsa:MessageID>\n" +
            "      <wsa:Action>http://schemas.xmlsoap.org/ws/2005/02/trust/RST/Issue</wsa:Action>\n" +
            "   </soapenv:Header>\n" +
            "   <soapenv:Body>\n" +
            "      <wst:RequestSecurityToken xmlns:wst=\"http://schemas.xmlsoap.org/ws/2005/02/trust\">\n" +
            "         <wst:RequestType>http://schemas.xmlsoap.org/ws/2005/02/trust/Issue</wst:RequestType>\n" +
            "         <wsp:AppliesTo xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\">\n" +
            "            <wsa:EndpointReference xmlns:wsa=\"http://schemas.xmlsoap.org/ws/2004/08/addressing\">\n" +
            "               <wsa:Address>https://localhost:10443/services/echo</wsa:Address>\n" +
            "            </wsa:EndpointReference>\n" +
            "         </wsp:AppliesTo>\n" +
            "         <wst:Lifetime>\n" +
            "            <wsu:Created xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">2020-02-08T04:45:01.651Z</wsu:Created>\n" +
            "            <wsu:Expires xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">2020-02-09T04:50:01.651Z</wsu:Expires>\n" +
            "         </wst:Lifetime>\n" +
            "         <wst:TokenType>http://docs.oasis-open.org/wss/oasis-wss-saml-token-profile-1.1#SAMLV2.0</wst:TokenType>\n" +
            "         <wst:KeyType>http://schemas.xmlsoap.org/ws/2005/02/trust/Bearer</wst:KeyType>\n" +
            "         <wst:Claims xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2005/02/trust\" wsp:Dialect=\"http://wso2.org/claims\">\n" +
            "            <wsid:ClaimType xmlns:wsid=\"http://schemas.xmlsoap.org/ws/2005/05/identity\" Uri=\"http://wso2.org/claims/givenname\"/>\n" +
            "            <wsid:ClaimType xmlns:wsid=\"http://schemas.xmlsoap.org/ws/2005/05/identity\" Uri=\"http://wso2.org/claims/emailaddress\"/>\n" +
            "         </wst:Claims>\n" +
            "      </wst:RequestSecurityToken>\n" +
            "   </soapenv:Body>\n" +
            "</soapenv:Envelope>";
}
