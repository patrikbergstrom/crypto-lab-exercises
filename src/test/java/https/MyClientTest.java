package https;

import org.junit.Test;

import java.security.cert.Certificate;

import static org.junit.Assert.assertEquals;

public class MyClientTest {

    @Test
    public void testRequestWithOwnKeyStore() throws Exception {
        int responseCode = MyClient.googleWithOwnKeyStore();
        assertEquals(200, responseCode);
    }

    @Test
    public void testRequestWithDefaultKeyStore() throws Exception {
        int responseCode = MyClient.googleWithDefaultKeyStore();
        assertEquals(200, responseCode);
    }

    @Test
    public void testGetCertificateChain() throws Exception {
        Certificate[] certificateChain = MyClient.getCertificateChain();

        assertEquals(3, certificateChain.length);
    }
}
