package crypto;

import org.junit.Test;

public class PBETest {

    @Test
    public void testEncrypt() throws Exception {
        PBE pbe = new PBE();

        pbe.encrypt("hemlig data", "secret");
    }
}
