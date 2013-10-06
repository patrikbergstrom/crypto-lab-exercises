package crypto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GoodAESTest {

    @Test
    public void testEncryptAndDecrypt() throws Exception {
        GoodAES goodAES = new GoodAES();
        goodAES.initEncryptMode();

        GoodAES.AesEncryptResult encrypt = goodAES.encrypt("min indata");
        System.out.println(encrypt.getEncrypted());

        goodAES.initDecryptMode(encrypt.getIv());

        String decrypt = goodAES.decrypt(encrypt.getEncrypted());

        System.out.println(decrypt);

        assertEquals("min indata", decrypt);
    }

    @Test
    public void testSameInputIsEncryptedDifferently() throws Exception {
        GoodAES goodAES = new GoodAES();
        goodAES.initEncryptMode();

        GoodAES.AesEncryptResult encrypt = goodAES.encrypt("min indata");

        goodAES.initEncryptMode();
        GoodAES.AesEncryptResult encrypt2 = goodAES.encrypt("min indata");

        assertFalse(encrypt.getEncrypted().equals(encrypt2.getEncrypted()));

    }
}
