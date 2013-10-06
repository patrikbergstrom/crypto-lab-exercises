package crypto;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author Patrik Bergström
 */
public class BadAES {

    private final String base64EncodedKey = "gLPzAAog9wXfCtkp7OdASwcnEcCEejs0eKryIYbqoAw=";
    private final SecretKey secretKey = new SecretKeySpec(Base64.decodeBase64(base64EncodedKey.getBytes()), "AES");
    private final Cipher cipher;

    public BadAES() throws Exception {
        cipher = Cipher.getInstance("AES"); // Bad
    }

    public void initEncryptMode() throws InvalidKeyException {
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
    }

    public void initDecryptMode() throws InvalidKeyException {
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
    }

    public String encrypt(String input) throws Exception {

        /* Insert code here that encrypts the input */
        byte[] bytes = new byte[0]; // remove

        String encrypted = new String(Base64.encodeBase64(bytes));
        System.out.println(encrypted);

        return encrypted;
    }

    public String decrypt(String encrypted) throws Exception {
        /* Insert code which decrypts */
        byte[] bytes = new byte[0]; // remove

        return new String(bytes);
    }
}
