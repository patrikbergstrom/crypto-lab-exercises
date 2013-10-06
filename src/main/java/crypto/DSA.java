package crypto;

import org.apache.commons.codec.binary.Base64;

import java.security.*;

public class DSA {

    private PublicKey publicKey;
    private PrivateKey privateKey;

    public DSA() throws NoSuchAlgorithmException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DSA");
        kpg.initialize(1024);
        KeyPair keyPair = kpg.generateKeyPair();
        publicKey = keyPair.getPublic();
        privateKey = keyPair.getPrivate();
    }

    public String buildSignature(String input) throws Exception {

        Signature dsa = Signature.getInstance("DSA");

        dsa.initSign(privateKey);

        dsa.update(input.getBytes());

        byte[] sign = dsa.sign();

        return new String(Base64.encodeBase64(sign));
    }

    public boolean verify(String input, String signature) throws Exception {

        Signature dsa = Signature.getInstance("DSA");
        dsa.initVerify(publicKey);

        dsa.update(input.getBytes());

        return dsa.verify(Base64.decodeBase64(signature.getBytes()));
    }
}
