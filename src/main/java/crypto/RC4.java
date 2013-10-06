package crypto;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * @author Patrik Bergström
 */
public class RC4 {

    private String base64EncodedKey = "p6Zl658/0CdklRQLgqgR/h7SwnP1PhFFTP6qv9RNmnc=";

    public String encrypt(String input) throws Exception {

        Cipher cipher = Cipher.getInstance("RC4");

        byte[] key = Base64.decodeBase64(base64EncodedKey.getBytes());
        SecretKey secretKey = new SecretKeySpec(key, "RC4");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] bytes = cipher.doFinal(input.getBytes());

        String encrypted = new String(Base64.encodeBase64(bytes));

        System.out.println(encrypted);

        return encrypted;
    }

    public String decrypt(String encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance("RC4");

        byte[] key = Base64.decodeBase64(base64EncodedKey.getBytes());
        SecretKey secretKey = new SecretKeySpec(key, "RC4");

        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] bytes = cipher.doFinal(Base64.decodeBase64(encrypted.getBytes()));

        String decrypted = new String(bytes);

        System.out.println(decrypted);

        return decrypted;
    }
}
