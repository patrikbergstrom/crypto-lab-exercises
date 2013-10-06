package https;

import org.junit.Test;

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
}
