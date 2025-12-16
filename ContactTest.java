// Developer - Ryan Ward
// See Contact class for details


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ContactTest {
    @Test
    void testContactClass() {
        Contact contact = new Contact("12345", "Ryan", "Ward", "6055551234", "123 Any Street");
        // simplified assertions based on IDE suggestion (was assertTrue)
        assertEquals("12345", contact.getContactId());
        assertEquals("Ryan", contact.getFirstName());
        assertEquals("Ward", contact.getLastName());
        assertEquals("6055551234", contact.getPhone());
        assertEquals("123 Any Street", contact.getAddress());
    }

    @Test
    void testContactIdTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678910", "Ryan", "Ward", "6055551234", "123 Any Street");
        });
    }
    @Test
    void testFirstNameTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ryan the great sage", "Ward", "6055551234", "123 Any Street");
        });
    }
    @Test
    void testLastNameTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ryan", "Ward the magnificent", "6055551234", "123 Any Street");
        });
    }
    @Test
    void testPhoneTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ryan", "Ward", "6055551234123", "123 Any Street");
        });
    }
    @Test
    void testPhoneTooShort() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ryan", "Ward", "605555", "123 Any Street");
        });
    }
    @Test
    void testPhoneNotDigits() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ryan", "Ward", "123abc4567", "123 Any Street");
        });
    }
    @Test
    void testAddressTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678910", "Ryan", "Ward", "6055551234", "123 Any Street, VeryLongTownName, VeryLongStateName, VeryLongCountryName, VeryLongPlanetName");
        });
    }
    @Test
    void testContactIdIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Ryan", "Ward", "6055551234", "123 Any Street");
        });
    }
    @Test
    void testFirstNameIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Ward", "6055551234", "123 Any Street");
        });
    }
    @Test
    void testLastNameIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ryan", null, "6055551234", "123 Any Street");
        });
    }
    @Test
    void testPhoneIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ryan", "Ward", null, "123 Any Street");
        });
    }
    @Test
    void testAddressIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ryan", "Ward", "6055551234", null);
        });
    }
}
