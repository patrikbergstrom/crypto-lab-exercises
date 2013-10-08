package crypto;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.generators.OpenSSLPBEParametersGenerator;
import org.bouncycastle.jcajce.provider.symmetric.AES;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Provider;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;

public class PBE {

    private final String theSalt = "theSalt";

    public String encrypt(String data, String password) throws Exception {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());

        Cipher cipher = Cipher.getInstance("PBEWithSHA256And256BitAES-CBC-BC");

        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithSHA256And256BitAES-CBC-BC");
        SecretKey secretKey = keyFactory.generateSecret(keySpec);

        AlgorithmParameterSpec spec = new PBEParameterSpec(theSalt.getBytes(), 1000);

        cipher.init(Cipher.ENCRYPT_MODE, secretKey, spec);

        byte[] bytes = cipher.doFinal(data.getBytes());

        return new String(Base64.encodeBase64(bytes));
    }

    public String decrypt(String encrypted, String password) throws Exception {

        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());

        Cipher cipher = Cipher.getInstance("PBEWithSHA256And256BitAES-CBC-BC");

        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithSHA256And256BitAES-CBC-BC");
        SecretKey secretKey = keyFactory.generateSecret(keySpec);

        AlgorithmParameterSpec spec = new PBEParameterSpec(theSalt.getBytes(), 1000);

        cipher.init(Cipher.DECRYPT_MODE, secretKey, spec);

        byte[] bytes = cipher.doFinal(Base64.decodeBase64(encrypted.getBytes()));

        return new String(bytes);
    }
}
