package crypto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SHATest {

    @Test
    public void testDigest() throws Exception {
        String hash = SHA.digest("aseio", "teststräng");

        System.out.println(hash);

        assertEquals("kIkHnURk5ebabDPwp97MSQe9yXLPwRgN0yYeycoTCRLnMR6LyPckFs1ASR59dnrp147m3JrNnTtI5v/R2FhD1w==", hash);
    }
}
