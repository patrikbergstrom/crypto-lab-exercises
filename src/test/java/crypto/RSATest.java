package crypto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RSATest {

    @Test
    public void testEncryptAndDecrypt() throws Exception {
        RSA rsa = new RSA();

        String encrypted = rsa.encrypt("apa");

        String decrypt = rsa.decrypt(encrypted);

//        assertEquals();
        assertEquals("apa", decrypt);
    }
}
