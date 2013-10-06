package crypto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BadAESTest {

    @Test
    public void testEncryptAndDecrypt() throws Exception {
        BadAES badAes = new BadAES();
        badAes.initEncryptMode();
        String encrypt = badAes.encrypt("min indata");

        badAes.initDecryptMode();

        String decrypt = badAes.decrypt(encrypt);

        assertEquals("min indata", decrypt);
    }
}
