package crypto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SHATest {

    @Test
    public void testDigest() throws Exception {
        String hash = SHA.digest("aseio", "teststräng");

        System.out.println(hash);

        assertEquals("2SyaB4pESEZE4dKcXWcGGE5FSCXhlEDsO3TB1ij2N3ZHQaRH7/6tWEToNxU+9tlcWw5swCKXeUFwVsumGERTyg==", hash);
    }
}
