package crypto;

import javax.crypto.spec.DHParameterSpec;
import java.math.BigInteger;

/**
 * @author Patrik Bergström
 */
public class DH {

    public static void main(String[] args) throws Exception {

        Alice alice = new Alice();
        Bob bob = new Bob();

        alice.init(); // Decide p and g
        DHParameterSpec pAndG = alice.getPAndG();

        bob.setPAndG(pAndG);

        BigInteger capitalA = alice.getA();

        bob.setCapitalA(capitalA);

        BigInteger capitalB = bob.getCapitalB();

        alice.setCapitalB(capitalB);

        BigInteger sharedSecretAlice = alice.getSharedSecret();
        BigInteger sharedSecretBob = bob.getSharedSecret();

        System.out.println("Alice: " + sharedSecretAlice);
        System.out.println("Bob: " + sharedSecretBob);
    }

    public static class Alice {

        private final BigInteger secret;
        private BigInteger g;
        private BigInteger p;
        private BigInteger capitalB;

        public Alice() {
            this.secret = new BigInteger("6");
        }

        public void init() {
            g = new BigInteger("5");
            p = new BigInteger("23");
        }

        public DHParameterSpec getPAndG() {
            return new DHParameterSpec(p, g);
        }

        public BigInteger getA() {
            return g.pow(secret.intValue()).mod(p);
        }

        public void setCapitalB(BigInteger capitalB) {
            this.capitalB = capitalB;
        }

        public BigInteger getSharedSecret() {
            return capitalB.pow(secret.intValue()).mod(p);
        }
    }

    public static class Bob {

        private final BigInteger secret;
        private BigInteger g;
        private BigInteger p;
        private BigInteger capitalA;

        public Bob() {
            this.secret = new BigInteger("15");
        }

        public void setPAndG(DHParameterSpec pAndG) {
            this.p = pAndG.getP();
            this.g = pAndG.getG();
        }

        public void setCapitalA(BigInteger capitalA) {
            this.capitalA = capitalA;
        }

        public BigInteger getCapitalB() {
            return g.pow(secret.intValue()).mod(p);
        }

        public BigInteger getSharedSecret() {
            return capitalA.pow(secret.intValue()).mod(p);
        }
    }
}
