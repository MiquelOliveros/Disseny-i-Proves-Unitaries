package data;

import org.junit.jupiter.api.Assertions;
import Exception.NullParameterException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DigitalSignatureTest {

    private DigitalSignature digital;
    private static byte[] digital_signature = "digital_signature".getBytes();
    private static byte[] digital_signature1 = "digital_signature1".getBytes();
    private static byte[] digital_signature2 = "digital_signature2".getBytes();

    @Test
    @DisplayName("DigitalSignature equals")
    void test_equals() {
        DigitalSignature signature = new DigitalSignature(digital_signature);
        DigitalSignature signature1 = new DigitalSignature(digital_signature1);
        DigitalSignature signature2 = new DigitalSignature(digital_signature2);
        DigitalSignature signature3 = new DigitalSignature(digital_signature);

        Assertions.assertNotEquals(signature,signature1);
        Assertions.assertNotEquals(signature,signature2);
        Assertions.assertEquals(signature,signature3);
    }

    @Test
    @DisplayName("DigitalSignature hashCode")
    void test_hashCode() {
        DigitalSignature signature = new DigitalSignature(digital_signature);
        DigitalSignature signature1 = new DigitalSignature(digital_signature1);
        DigitalSignature signature2 = new DigitalSignature(digital_signature2);
        DigitalSignature signature3 = new DigitalSignature(digital_signature);

        Assertions.assertNotEquals(signature.hashCode(),signature1.hashCode());
        Assertions.assertNotEquals(signature.hashCode(),signature2.hashCode());
        Assertions.assertEquals(signature.hashCode(),signature3.hashCode());
    }

    @Test
    @DisplayName("DigitalSignature toString")
    void test_toString() {
        DigitalSignature signature = new DigitalSignature(digital_signature);
        String out = "DigitalSignature{" + "signature='" + digital_signature + '\'' + '}';
        Assertions.assertEquals(out,signature.toString());
    }

    @Test
    @DisplayName("DigitalSignature Exception")
    void testDigitalSignatureException(){
        Assertions.assertThrows(NullParameterException.class,
                () -> digital = new DigitalSignature(null));
    }
}