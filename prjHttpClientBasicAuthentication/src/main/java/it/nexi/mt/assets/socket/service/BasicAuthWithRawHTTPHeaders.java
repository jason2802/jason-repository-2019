package it.nexi.mt.assets.socket.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;


//

public class BasicAuthWithRawHTTPHeaders {
    
    private static final String URL_SECURED_BY_BASIC_AUTHENTICATION = "http://localhost:8081/spring-security-rest-basic-auth/api/foos/1";
    private static final String DEFAULT_USER = "user1";
    private static final String DEFAULT_PASS = "user1Pass";
    
    private static final String URL_SECURED_BY_BASIC_AUTHENTICATION_2 = "http://browserspy.dk/password-ok.php";
    private static final String DEFAULT_USER_2 = "test";
    private static final String DEFAULT_PASS_2 = "test";
    
    
    @SuppressWarnings("unused")
    private void basicAuthWithRawHTTPHeaders ( ) throws ClientProtocolException, IOException {
        HttpGet request = new HttpGet(URL_SECURED_BY_BASIC_AUTHENTICATION);
        String auth = DEFAULT_USER + ":" + DEFAULT_PASS;
        byte[] encodedAuth = Base64.encodeBase64(
          auth.getBytes(StandardCharsets.ISO_8859_1));
        String authHeader = "Basic " + new String(encodedAuth);
        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
         
        HttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = client.execute(request);
         
        int statusCode = response.getStatusLine().getStatusCode();
        assertThat(statusCode, equalTo(HttpStatus.SC_OK));
    
    }
    
    /*
        So, even though there is not auth cache, Basic Authentication is still performed correctly and the 200 OK is sent back.
     * */
}
