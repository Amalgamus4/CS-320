// Developer - Ryan Ward
// See Contact class for details

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {

    // variables used throughout testing
    private ContactService contactService;
    private Contact testContact;

    @BeforeEach
    void setupConditions(){
        contactService = new ContactService();
        testContact = new Contact("54321", "Boba", "Fett", "5555556543", "876 Tatooine Way");
        contactService.addContact(testContact);
    }

    @Test
    void testSingleInstance() {
        // verify only one instance of ContactService is created
        ContactService contactService1 = ContactService.getInstance();
        ContactService contactService2 = ContactService.getInstance();
        assertSame(contactService1, contactService2);
    }
    @Test
    void testAddExistingContact() {
        // check that testContact cannot be added as it already exists from setup
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(testContact);
        });
    }
    @Test
    void testAddContactSucceeded() {
        // check that a new contact can be added
        Contact newContact = new Contact("8675309","Han", "Solo", "8887891234", "987 Correlia St");
        contactService.addContact(newContact);
        assertTrue(contactService.getContacts().contains(newContact));
    }
    @Test
    void testDeleteContact() {
        // check that an existing contact can be deleted
        String contactIdToRemove = "54321"; // created during setup
        contactService.deleteContact(contactIdToRemove);
        Contact contactToDelete = new Contact();
        // iterate through contacts to find if deleted contact ID exists
        for (Contact c : contactService.getContacts()) {
            if (c.getContactId().equals(contactIdToRemove)) {
                contactToDelete = c;
            }
        }
        // verify deleted contact does not exist in contact list
        assertFalse(contactService.getContacts().contains(contactToDelete));
    }
    @Test
    void testDeleteNonexistentContact() {
        String contactToDelete = "951";
        assertThrows(IllegalArgumentException.class, () -> {
           contactService.deleteContact(contactToDelete);
        });
    }
    @Test
    void testUpdateContactFirstName() {
        String newFirstName = "Jango";
        contactService.updateFirstName(testContact.getContactId(), newFirstName);
        assertEquals(newFirstName, testContact.getFirstName());
    }
    @Test
    void testUpdateFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName(testContact.getContactId(), null);
        });
    }
    @Test
    void testUpdateFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName((testContact.getContactId()), "Savior of the Ewoks, Lord C3PO");
        });
    }
    @Test
    void testUpdateContactLastName() {
        String newLastName = "Skywalker";
        contactService.updateLastName(testContact.getContactId(), newLastName);
        assertEquals(newLastName, testContact.getLastName());
    }
    @Test
    void testUpdateLastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateLastName(testContact.getContactId(), null);
        });
    }
    @Test
    void testUpdateLastNameTooLong() {
        String newLastName = "Amidala of Planet Naboo";
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateLastName((testContact.getContactId()), newLastName);
        });
    }
    @Test
    void testUpdateContactPhone() {
        String newPhone = "1856479874";
        contactService.updatePhone(testContact.getContactId(), newPhone);
        assertEquals(newPhone, testContact.getPhone());
    }
    @Test
    void testUpdatePhoneNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updatePhone(testContact.getContactId(), null);
        });
    }
    @Test
    void testUpdatePhoneTooLong() {
        String newPhone = "10987654321";
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateLastName((testContact.getContactId()), newPhone);
        });
    }
    @Test
    void testUpdatePhoneTooShort() {
        String newPhone = "456";
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updatePhone((testContact.getContactId()), newPhone);
        });
    }
    @Test
    void testUpdatePhoneNotDigits() {
        String newPhone = "abcdef";
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updatePhone((testContact.getContactId()), newPhone);
        });
    }
    @Test
    void testUpdateContactAddress(){
        String newAddress = "6544 Kamino Blvd";
        contactService.updateAddress(testContact.getContactId(), newAddress);
        assertEquals(newAddress, testContact.getAddress());
    }
    @Test
    void testUpdateAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateAddress(testContact.getContactId(), null);
        });
    }
    @Test
    void testUpdateAddressTooLong() {
        String newAddress = "This is a really long address that should fail this test miserably";
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateAddress((testContact.getContactId()), newAddress);
        });
    }
}
