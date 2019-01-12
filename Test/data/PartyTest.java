package data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import Exception.NullParameterException;

class PartyTest {

    private Party party;
    private static final String name1 = "party1";
    private static final String name2 = "party2";

    @Test
    @DisplayName("Party equals")
    void test_equals() {
        Party name_1 = new Party(name1);
        Party name_2 = new Party(name2);
        Party name_equal = new Party(name1);

        Assertions.assertEquals(name_1, name_equal);
        Assertions.assertNotEquals(name_1, name_2);
    }

    @Test
    @DisplayName("Party hashCode")
    void test_hashCode() {
        Party name_1 = new Party(name1);
        Party name_2 = new Party(name2);
        Party name_equal = new Party(name1);

        Assertions.assertEquals(name_1.hashCode(), name_equal.hashCode());
        Assertions.assertNotEquals(name_1.hashCode(), name_2.hashCode());
    }

    @Test
    @DisplayName("Party toString")
    void test_toString() {
        Party name = new Party(name1);
        String out = "Party{" + "name='" + name1 + '\'' + '}';
        Assertions.assertEquals(out,name.toString());
    }

    @Test
    @DisplayName("Party Exception")
    void testPartyException(){
        Assertions.assertThrows(NullParameterException.class,
                () -> party = new Party(null));
    }
}