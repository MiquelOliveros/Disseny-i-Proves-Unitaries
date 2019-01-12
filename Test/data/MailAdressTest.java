package data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailAdressTest {

    private static final String mail = "abcd@gmail.com";
    private static final String mail1 = "abeg@hotmail.com";

    @Test
    @DisplayName("MailAdressTest equals")
    void test_equals() {
        MailAdress mail_1 = new MailAdress(mail);
        MailAdress mail_2 = new MailAdress(mail1);
        MailAdress mail_equal = new MailAdress(mail);

        Assertions.assertEquals(mail_1,mail_equal);
        Assertions.assertNotEquals(mail_1,mail_2);
    }

    @Test
    @DisplayName("MailAdressTest hashCode")
    void test_hashCode() {
        MailAdress mail_1 = new MailAdress(mail);
        MailAdress mail_2 = new MailAdress(mail1);
        MailAdress mail_equal = new MailAdress(mail);

        Assertions.assertEquals(mail_1.hashCode(),mail_equal.hashCode());
        Assertions.assertNotEquals(mail_1.hashCode(),mail_2.hashCode());
    }

    @Test
    @DisplayName("MailAdressTest toString")
    void test_toString() {
        MailAdress mailAdress = new MailAdress(mail);
        String out = "MailAdress{" + "adress='" + mail + '\'' + '}';
        Assertions.assertEquals(out,mailAdress.toString());
    }
}