package ng.hx.study.maintest.basicJava;

import java.util.Base64;

public class TestBase64 {
    public static void main(String[] args) {
        Base64.Encoder encoder = Base64.getEncoder();
        String plaintext="cms:secret";
        String encoded = encoder.encodeToString(plaintext.getBytes());
        System.out.println(encoded);
    }
}
