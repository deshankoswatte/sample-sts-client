# ws-trust-client

# Configuring WS-Trust Security Token Service

WSO2 Identity Server uses the security token service (STS) as the
[WS-Trust](https://is.docs.wso2.com/en/latest/learn/ws-trust) implementation. The STS is capable of issuing
SAML 1.1 and 2.0 security tokens and has a SOAP/XML API for token
issuance. This API can be secured with the
`         UserNameToken        ` or with any other WS-Security mechanism
as explained below.

#### Securing the Security Token Service

According to the Trust Brokering model defined in the WS-Trust
specification, the users should authenticate themselves to the STS
before obtaining a token. STS may use this authentication information
when constructing the security token. For example, STS may populate the
required claims based on the user name provided by the subject.
Therefore, the STS service needs to be secured.

STS is configured under the **Resident Identity Provider** section of
the WSO2 Identity Server [Management
Console](https://is.docs.wso2.com/en/latest/setup/getting-started-with-the-management-console).

To secure the Security Token Service:

1.  On the **Main** tab, click **Identity \> Identity Providers \>
    Resident**.

2.  Enter the required values as given below.

    <table>
    <thead>
    <tr class="header">
    <th>Field</th>
    <th>Description</th>
    <th>Sample Value</th>
    </tr>
    </thead>
    <tbody>
    <tr class="odd">
    <td><strong>Home Realm Identifier</strong></td>
    <td>This is the domain name of the identity provider. If you do not enter a value here, when an authentication request comes to WSO2 Identity Server, a user will be prompted to specify a domain. You can enter multiple identifiers as a comma-separated list.</td>
    <td><code>               localhost              </code></td>
    </tr>
    <tr class="even">
    <td><strong>Idle Session Time Out</strong></td>
    <td>This is the duration in minutes for which an SSO session can be idle for. If WSO2 Identity Server does not receive any SSO authentication requests for the given duration, a session time out occurs. The default value is <code>               15              </code> .</td>
    <td><code>               15              </code></td>
    </tr>
    <tr class="odd">
    <td><strong>Remember Me Period</strong></td>
    <td><div class="content-wrapper">
    <p>This is the duration in weeks for which WSO2 Identity Server should remember an SSO session given that the <strong>Remember Me</strong> option is selected in the WSO2 Identity Server login screen.</p>
    <p>The default value is <code>                 2                </code> weeks.</p>
    </div></td>
    <td><code>               2              </code></td>
    </tr>
    </tbody>
    </table>

3.  Under the **Inbound Authentication Configuration** section, click
    **Security Token Service Configuration \> Apply Security Policy**
    .  
4.  Select **Yes** in the **Enable Security?** drop down and  select a
    pre-configured security scenario according to your requirements. For
    this tutorial, use **UsernameToken** under the **Basic Scenarios**
    section.

5.  Click **Next**. The user domain and user group selection appears.

6.  Provide the required details as follows:
    1.  Select **ALL-USER-STORE-DOMAINS**.
    2.  Select the role you created to grant permission to access
        secured service. In this example, the admin role is used.
        Next, click **Finish**.
        
7.  Click **Finish**.

8.  Click **Ok** on the confirmation dialog window that appears.

9.  Click **Update** to complete the process.

Now STS is configured and secured with a username and password. Only
users with the Admin role can consume the service.

The next step is to add a service provider to consume the STS.

#### Adding a service provider for the STS client
	
!!! Tip "Before you begin"	
    You must first
    [register a service provider](https://is.docs.wso2.com/en/latest/learn/adding-and-configuring-a-service-provider/#adding-a-service-provider).
    
    To register a service provider:
	 
	 1. Sign in to WSO2 Identity Server Management Console as an admin.
	 2. On the Main menu, click **Identity** > **Service Providers** > **Add**.
	 3. Enter a service provider name.
	 4.	Click Register. The Service Provider Details page appears.
	 
1.  Under the **Inbound Authentication Configuration** section, click
    **WS-Trust Security Token Service Configuration** **\>**
    **Configure**. The STS Configuration page appears. 
    
2.  Enter the required details as given below.
 	
	<table>
	   <thead>
		  <tr class="header">
			 <th>Field</th>
			 <th>Description</th>
			 <th>Sample Value</th>
		  </tr>
	   </thead>
	   <tbody>
		  <tr class="odd">
			 <td><strong>Endpoint Address</strong></td>
			 <td>
				<div class="content-wrapper">
				   <div>
					  Enter the trusted relying party's <strong>endpoint address,</strong> which is the <strong></strong> endpoint address of the Security Token Service.
					  <p>The endpoint must be used as the service <code>                  URL                 </code> to which the token gets delivered by the STS client. Then select the public certificate imported. Tokens issued are encrypted using the public certificate of the trusted relying party. Therefore, the consumer who obtains this token, to invoke the RP service, will not be able to see the token.</p> 
		    		   <div class="admonition note">
						<p class="admonition-title">Note</p>
		    		   		 Make sure to upload the certificate of the relying party to the truststore. For instructions, see <a href="https://docs.wso2.com/display/ADMIN44x/Creating+New+Keystores#CreatingNewKeystores-ca_certificateAddingCA-signedcertificatestokeystores">Adding CA-signed certificates to keystores</a>.</div>
					  <br/>
				   </div>
				</div>
			 </td>
			 <td><code>               https://localhost:9444/services/echo              </code></td>
		  </tr>
		  <tr class="even">
			 <td><strong>Certificate Alias</strong></td>
			 <td>This is the alias of the certificate.</td>
			 <td><code>               wso2carbon              </code></td>
		  </tr>
	   </tbody>
	</table>

3.  Click **Update** to save the changes made to the service provider.


#### Running the client

1.  Open the client and run `mvn clean install` on the root folder.

2.  Run the command `java -cp ws-trust-client/target/ws-trust-client-1.0-SNAPSHOT.jar org.wso2.samples.is.sts.wstrust.client.Client`.

3.  You will see the requests sent to the STS and the responses received.
