package it.nexi.mt.assets.socket.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;


// Let’s start with the standard way of configuring Basic Authentication on the HttpClient – via a CredentialsProvider:
public class BasicAuthenticationWithTheAPI2 {
    
    private static final String URL_SECURED_BY_BASIC_AUTHENTICATION = "http://localhost:8081/spring-security-rest-basic-auth/api/foos/1";
    private static final String DEFAULT_USER = "user1";
    private static final String DEFAULT_PASS = "user1Pass";
    
    private static final String URL_SECURED_BY_BASIC_AUTHENTICATION_2 = "http://browserspy.dk/password-ok.php";
    private static final String DEFAULT_USER_2 = "test";
    private static final String DEFAULT_PASS_2 = "test";
    
    
    @SuppressWarnings("unused")
    private void basicAuthenticationWithTheAPI ( ) throws ClientProtocolException, IOException {
        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials( DEFAULT_USER_2, DEFAULT_PASS_2 );
        provider.setCredentials(AuthScope.ANY, credentials);
          
        HttpClient client = HttpClientBuilder.create()
          .setDefaultCredentialsProvider(provider)
          .build();
         
        HttpResponse response = client.execute( new HttpGet( URL_SECURED_BY_BASIC_AUTHENTICATION_2 ) );
        int statusCode = response.getStatusLine()
                                 .getStatusCode();
          
        assertThat( statusCode, equalTo( HttpStatus.SC_OK ) );
    
    }
    
    /*
         The entire Client-Server communication is now clear:
            
            the Client sends the HTTP Request with no credentials
            the Server sends back a challenge
            the Client negotiates and identifies the right authentication scheme
            the Client sends a second Request, this time with credentials
     * */
}
