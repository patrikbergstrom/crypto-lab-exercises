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

        SecretKey secretKey = null;// Skapa en nyckel med hjälp av base64EncodedKey

        // Gör lite grejer hör för att kryptera input

        String encrypted = null; // Ta bort
        System.out.println(encrypted);

        return encrypted;
    }

    public String decrypt(String encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance("RC4");

        SecretKey secretKey = null;// Skapa en nyckel med hjälp av base64EncodedKey

        // Gör lite saker här för att dekryptera

        String decrypted = null; // Ta bort
        System.out.println(decrypted);

        return decrypted;
    }
}
