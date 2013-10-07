package crypto;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Patrik Bergström
 */
public class SHA {

    // Digest with SHA-512. Concatenate salt and input and then hash thousand rounds. Make a base64-encoded string and return.
    public static String digest(String salt, String input) throws Exception {

        return null;
    }
}
