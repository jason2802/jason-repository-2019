package it.nexi.mt.assets.socket.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HttpContext;


// Out of the box, the HttpClient doesn’t do preemptive authentication – this has to be an explicit decision made by the client.
//
//First, we need to create the HttpContext – pre-populating it with an authentication cache with the right type of authentication scheme pre-selected. 
//This will mean that the negotiation from the previous example is no longer necessary – Basic Authentication is already chosen:
public class PreemptiveBasicAuthentication {
    
    private static final String URL_SECURED_BY_BASIC_AUTHENTICATION = "http://localhost:8081/spring-security-rest-basic-auth/api/foos/1";
    private static final String DEFAULT_USER = "user1";
    private static final String DEFAULT_PASS = "user1Pass";
    
    private static final String URL_SECURED_BY_BASIC_AUTHENTICATION_2 = "http://browserspy.dk/password-ok.php";
    private static final String DEFAULT_USER_2 = "test";
    private static final String DEFAULT_PASS_2 = "test";
    
    
    @SuppressWarnings("unused")
    private void preemptiveBasicAuthentication ( ) throws ClientProtocolException, IOException {
        
        HttpHost targetHost = new HttpHost("localhost", 8080, "http");
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(AuthScope.ANY, 
                                    new UsernamePasswordCredentials(DEFAULT_USER, DEFAULT_PASS));
         
        AuthCache authCache = new BasicAuthCache();
        authCache.put(targetHost, new BasicScheme());
         
        // Add AuthCache to the execution context
        final HttpClientContext context = HttpClientContext.create();
        context.setCredentialsProvider(credsProvider);
        context.setAuthCache(authCache);
        
    }
    
    @SuppressWarnings("unused")
    private void sendThePreAuthenticationRequest() throws ClientProtocolException, IOException{
        HttpClient client = HttpClientBuilder.create().build();
        HttpContext context = null;
        Object response = client.execute(
          new HttpGet(URL_SECURED_BY_BASIC_AUTHENTICATION), context);
         
        int statusCode = ((HttpResponse) response).getStatusLine().getStatusCode();
        assertThat(statusCode, equalTo(HttpStatus.SC_OK));
        
    }
    
    /*
         Everything looks OK:

            the “Basic Authentication” scheme is pre-selected
            the Request is sent with the Authorization header
            the Server responds with a 200 OK
            Authentication succeeds
     * */
}
