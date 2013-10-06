package crypto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RC4Test {

    @Test
    public void testEncrypt() throws Exception {
        RC4 rc4 = new RC4();

        String encrypt = rc4.encrypt("min indata");

        assertEquals("dsluQ/Alfd3ZpQ==", encrypt);
    }

    @Test
    public void testDecrypt() throws Exception {
        RC4 rc4 = new RC4();

        String decrypt = rc4.decrypt("dsluQ/Alfd3ZpQ==");

        assertEquals("min indata", decrypt);
    }
}
