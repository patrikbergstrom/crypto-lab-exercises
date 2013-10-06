package crypto;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Patrik Bergström
 */
public class SHA {

    // Digest with SHA-512. First time with salt and then one thousand rounds. Make a base64-encoded string and return.
    public static String digest(String salt, String input) throws NoSuchAlgorithmException {

        MessageDigest sha = MessageDigest.getInstance("SHA-512");

        byte[] digest = sha.digest((salt + input).getBytes());
        for (int i = 0; i < 1000; i++) {
            digest = sha.digest(digest);
        }

        String result = new String(Base64.encodeBase64(digest));
        return result;
    }
}
