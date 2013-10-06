package crypto;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;

/**
 * @author Patrik Bergström
 */
public class GoodAES {

    private final String base64EncodedKey = "gLPzAAog9wXfCtkp7OdASwcnEcCEejs0eKryIYbqoAw=";
    private final SecretKey secretKey = new SecretKeySpec(Base64.decodeBase64(base64EncodedKey.getBytes()), "AES");
    private final Cipher cipher;

    public GoodAES() throws Exception {
        cipher = Cipher.getInstance("sätt en sträng som ger AES med CBC chiffer-läge och PKCS5Padding");
    }

    public void initEncryptMode() throws InvalidKeyException {
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
    }
    public void initDecryptMode(byte[] initializationVector) throws Exception {
        cipher.init(Cipher.DECRYPT_MODE, secretKey); // Här måste en tredje parameter läggas till som använder initializationVector
    }

    public AesEncryptResult encrypt(String input) throws Exception {

        byte[] iv = new byte[0]; // Ersätt med något som ger en initialiserings-vektor
        byte[] bytes = cipher.doFinal(input.getBytes());

        String encrypted = new String(Base64.encodeBase64(bytes));
        System.out.println(encrypted);

        return new AesEncryptResult(iv, encrypted);
    }

    public String decrypt(String encrypted) throws Exception {
        byte[] bytes = cipher.doFinal(Base64.decodeBase64(encrypted.getBytes()));

        return new String(bytes);
    }

    public static class AesEncryptResult {

        private byte[] iv;
        private String encrypted;

        public AesEncryptResult(byte[] iv, String encrypted) {
            this.iv = iv;
            this.encrypted = encrypted;
        }

        public byte[] getIv() {
            return iv;
        }

        public String getEncrypted() {
            return encrypted;
        }
    }
}
