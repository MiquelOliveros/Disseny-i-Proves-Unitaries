package data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NifTest {

    private Nif nifAssert;
    private static final String nif = "12345678G";
    private static final String nif1 = "87654321G";

    @Test
    @DisplayName("Nif equals")
    void test_equals() {
        Nif nif_1 = new Nif(nif);
        Nif nif_2 = new Nif(nif1);
        Nif nif_equal = new Nif(nif);

        Assertions.assertEquals(nif_1, nif_equal);
        Assertions.assertNotEquals(nif, nif_2);
    }

    @Test
    @DisplayName("Nif hashCode")
    void test_hashCode() {
        Nif nif_1 = new Nif(nif);
        Nif nif_2 = new Nif(nif1);
        Nif nif_equal = new Nif(nif);

        Assertions.assertNotEquals(nif_1.hashCode(), nif_2.hashCode());
        Assertions.assertEquals(nif_1.hashCode(), nif_equal.hashCode());
    }

    @Test
    @DisplayName("Nif toString")
    void test_toString() {
        Nif nif_1 = new Nif(nif);
        String out = "Nif{" + "nif='" + nif + '\'' + '}';
        Assertions.assertEquals(out,nif_1.toString());
    }

    @Test
    @DisplayName("Nif Exception")
    void testNifException(){
        Assertions.assertThrows(NullParameterException.class,
                () -> nifAssert = new Nif(null));
        Assertions.assertThrows(NullParameterException.class,
                () -> nifAssert = new Nif("123456789A"));
        Assertions.assertThrows(NullParameterException.class,
                () -> nifAssert = new Nif("123456789"));
    }
}