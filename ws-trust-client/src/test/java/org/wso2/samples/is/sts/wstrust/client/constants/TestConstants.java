package org.wso2.samples.is.sts.wstrust.client.constants;

import java.util.Arrays;
import java.util.List;

public class TestConstants {

    public static final int NO_OF_DIFFERENCES_FOR_REQUEST_ST_RSTR = 17;
    public static final List<String> CHANGING_XPATHS_FOR_REQUEST_ST_RSTR = Arrays.asList(
            "/Envelope[1]/Header[1]/Security[1]/Timestamp[1]/@Id",
            "/Envelope[1]/Header[1]/Security[1]/Timestamp[1]/Created[1]/text()[1]",
            "/Envelope[1]/Header[1]/Security[1]/Timestamp[1]/Expires[1]/text()[1]",
            "/Envelope[1]/Header[1]/MessageID[1]/text()[1]",
            "/Envelope[1]/Body[1]/RequestSecurityTokenResponse[1]/RequestedAttachedReference[1]/SecurityTokenReference[1]/Reference[1]/@URI",
            "/Envelope[1]/Body[1]/RequestSecurityTokenResponse[1]/RequestedUnattachedReference[1]/SecurityTokenReference[1]/Reference[1]/@URI",
            "/Envelope[1]/Body[1]/RequestSecurityTokenResponse[1]/Lifetime[1]/Created[1]/text()[1]",
            "/Envelope[1]/Body[1]/RequestSecurityTokenResponse[1]/Lifetime[1]/Expires[1]/text()[1]",
            "/Envelope[1]/Body[1]/RequestSecurityTokenResponse[1]/RequestedSecurityToken[1]/Assertion[1]/@ID",
            "/Envelope[1]/Body[1]/RequestSecurityTokenResponse[1]/RequestedSecurityToken[1]/Assertion[1]/@IssueInstant",
            "/Envelope[1]/Body[1]/RequestSecurityTokenResponse[1]/RequestedSecurityToken[1]/Assertion[1]/Signature[1]/SignedInfo[1]/Reference[1]/@URI",
            "/Envelope[1]/Body[1]/RequestSecurityTokenResponse[1]/RequestedSecurityToken[1]/Assertion[1]/Signature[1]/SignedInfo[1]/Reference[1]/DigestValue[1]/text()[1]",
            "/Envelope[1]/Body[1]/RequestSecurityTokenResponse[1]/RequestedSecurityToken[1]/Assertion[1]/Signature[1]/SignatureValue[1]/text()[1]",
            "/Envelope[1]/Body[1]/RequestSecurityTokenResponse[1]/RequestedSecurityToken[1]/Assertion[1]/Signature[1]/KeyInfo[1]/X509Data[1]/X509Certificate[1]/text()[1]",
            "/Envelope[1]/Body[1]/RequestSecurityTokenResponse[1]/RequestedSecurityToken[1]/Assertion[1]/Conditions[1]/@NotBefore",
            "/Envelope[1]/Body[1]/RequestSecurityTokenResponse[1]/RequestedSecurityToken[1]/Assertion[1]/Conditions[1]/@NotOnOrAfter",
            "/Envelope[1]/Body[1]/RequestSecurityTokenResponse[1]/RequestedSecurityToken[1]/Assertion[1]/AuthnStatement[1]/@AuthnInstant"
    );
}
