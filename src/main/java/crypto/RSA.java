package crypto;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.spec.RSAPrivateKeySpec;

/**
 * @author Patrik Bergström
 */
public class RSA {

    private final KeyPair keyPair;
    private final Cipher cipher;

    public RSA() throws Exception {
        cipher = Cipher.getInstance("RSA");

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);

        keyPair = keyPairGenerator.generateKeyPair();
    }

    public String encrypt(String input) throws Exception {

//        Cipher cipher = Cipher.getInstance("RSA");

        /*KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);

        KeyPair keyPair = keyPairGenerator.generateKeyPair();*/

        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());

        byte[] bytes = cipher.doFinal(input.getBytes());

        String encrypted = new String(Base64.encodeBase64(bytes));

        return encrypted;
    }

    public String decrypt(String encrypted) throws Exception {

        cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());

        byte[] encBytes = Base64.decodeBase64(encrypted.getBytes());

        byte[] bytes = cipher.doFinal(encBytes);

        return new String(bytes);
    }
}
