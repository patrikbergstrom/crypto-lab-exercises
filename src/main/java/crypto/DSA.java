package crypto;

import org.apache.commons.codec.binary.Base64;

import java.security.*;

public class DSA {

    private PublicKey publicKey;
    private PrivateKey privateKey;

    public DSA() throws NoSuchAlgorithmException {
        // Generate keypair and initialize publicKey and privateKey.
    }

    public String buildSignature(String input) throws Exception {

        /*
        Gör allt som behövs för att signera
         */
        byte[] sign = new byte[0]; // remove

        return new String(Base64.encodeBase64(sign));
    }

    public boolean verify(String input, String signature) throws Exception {

        /*
        Gör allt som behövs för att verifiera.
         */
        return false;
    }
}
