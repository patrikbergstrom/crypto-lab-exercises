package crypto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PBETest {

    @Test
    public void testEncryptAndDecrypt() throws Exception {
        PBE pbe = new PBE();

        String data = "hemlig data";
        String encrypted = pbe.encrypt(data, "secret");

        String decrypted = pbe.decrypt(encrypted, "secret");

        assertEquals(data, decrypted);
    }
}
