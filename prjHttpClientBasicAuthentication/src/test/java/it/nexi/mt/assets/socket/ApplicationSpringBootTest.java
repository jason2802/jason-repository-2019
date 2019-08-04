package it.nexi.mt.assets.socket;

import it.nexi.mt.common.model.HeaderContext;
import it.nexi.mt.common.model.card.CardIdBuilder;
import it.nexi.mt.security.repository.SionmcesbubiRepository;
import it.nexi.mt.security.service.SecurityService;
import it.nexi.mt.security.utility.CryptManager;
import it.nexi.mt.services.security.model.GetPanAliasFromPanRequest;
import it.nexi.mt.services.security.model.GetPanFromPanAliasRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

@RunWith ( SpringRunner.class )
@SpringBootTest ( classes = ApplicationSpringBoot.class )
@ActiveProfiles ( "integration-tests" )
public class ApplicationSpringBootTest {

    private static final HeaderContext ctx = new HeaderContext();
    private static byte[] ivByte = new byte[] { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 };
    @Autowired
    private SecurityService service;
    @Autowired
    private SionmcesbubiRepository sionmcesbubiRepository;
    @Autowired
    private CryptManager cryptUtility;

    @Before
    public void setUp() {
        ctx.put( "MT_APPLICATION", "CH" )
                .put( "MT_USER", "NEXI" )
                .put( "MT_CHANNEL", "WEB" )
                .put( "MT_COMPANY_GROUP", "NEXI" )
                .put( "MT_COMPANY", "NEXI" )
                .put( "MT_REQUEST_ID", "NEXI" )
                .put( "MT_PARTNER", "NEXI" )
                .put( "MT_SESSION_ID", "NEXI" );
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void getPanAliasFromPan() {
        GetPanAliasFromPanRequest request = new GetPanAliasFromPanRequest()
                .cardId( Collections.singletonList( CardIdBuilder.panCard( "5127970100903328" ) ) );
        try {
            System.out.println( "RESPONSE: " + service.getPanAliasFromPan( request, ctx ) );
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    @Test
    public void getPanFromPanAlias() {
        GetPanFromPanAliasRequest request = new GetPanFromPanAliasRequest()
                .cardId( Collections.singletonList( CardIdBuilder.panAliasCard( "0100000000573165" ) ) );
        try {
            System.out.println( "RESPONSE: " + service.getPanFromPanAlias( request, ctx ) );
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCrypto() {
        try {
            String encryptionKey = sionmcesbubiRepository.selectEncryptionKey( ctx );
            byte[] keyAsBytes = encryptionKey.getBytes();
            String pan = cryptUtility.decryptCBC( keyAsBytes, "E52EC2084A0376D365F31980DB9D68D40B20C0F62E1AADC70925FB0647B22672", ivByte );
            System.out.println( "PAN: " + pan );
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

}
