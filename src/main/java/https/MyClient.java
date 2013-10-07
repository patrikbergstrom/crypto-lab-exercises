package https;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;

public class MyClient {

    /*
    Tips: Gå till https://www.google.com och hämta något av certifikaten i certifikat-kedjan, exportera det till fil
    och importera det till clientstore/clienttruststore.jks med hjälp av keytool.
     */
    public static int googleWithOwnKeyStore() throws Exception {

        // Init truststore
        KeyStore trustStore = KeyStore.getInstance("JKS");
        String clientTrustStore = MyClient.class.getClassLoader().getResource("clientstore/clienttruststore.jks").getPath();
        trustStore.load(new FileInputStream(clientTrustStore), "changeit".toCharArray());

        // Init trustManagerFactory
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(trustStore);

        // Init SSLContext
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustManagerFactory.getTrustManagers(), SecureRandom.getInstance("SHA1PRNG"));

        // Connect to Google with our sslContext
        URL url = new URL("https://www.google.com");
        URLConnection connection = url.openConnection();
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) connection;
        httpsURLConnection.setSSLSocketFactory(sslContext.getSocketFactory());

        // Get response code
        int responseCode = httpsURLConnection.getResponseCode();

        return responseCode;
    }

    public static int googleWithDefaultKeyStore() throws Exception {

        // Tips: SSLContext.getDefault()
        return 0;
    }

    public static Certificate[] getCertificateChain() throws Exception {

        URL url = new URL("https://www.google.com");

        // Sedan är det bara att fiska upp certifikat-kedjan :)

        return null;
    }
}