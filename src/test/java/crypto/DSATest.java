package crypto;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DSATest {

    @Test
    public void testBuildAndVerify() throws Exception {

        DSA dsa = new DSA();

        String signature = dsa.buildSignature("min text");

        assertTrue(dsa.verify("min text", signature));
    }
}
