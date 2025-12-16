// Developer - Ryan Ward
// See Contact class for details

import java.util.ArrayList;

public class ContactService {

    // array list to store contacts
    private ArrayList<Contact> contacts;

    // default constructor
    ContactService() {
        this.contacts = new ArrayList<>();
    }

    // Singleton pattern to ensure only one contact service exists
    private static ContactService instance;

    public static ContactService getInstance(){
        if (instance == null) {
            instance = new ContactService();
        }
        return instance;
    }

    // method for verifying and adding new contact
    public void addContact(Contact contact){
        // iterate through contacts to verify contact ID does not already exist
        for (Contact c : contacts) {
            if (c.getContactId().equals(contact.getContactId())) {
                throw new IllegalArgumentException("ID already in use");
            }
        }
        this.contacts.add(contact);
    }
    // method to check for existence of contact and remove it
    // using collection.removeIf per IDE suggestion (in place of enhanced for loop)
    public void deleteContact(String contactId){
       // first check if contact ID exists
        boolean contactExists = false;
        for (Contact c : contacts) {
            if (c.getContactId().equals(contactId)) {
                contactExists = true;
                break;
            }
        }
        if (!contactExists) {
              throw new IllegalArgumentException("ID does not exist");
        }
        // remove contact
        contacts.removeIf(c -> c.getContactId().equals(contactId));
    }
    // method to verify and update first name
    public void updateFirstName(String contactId, String firstName){
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        // iterate through contacts to find contact ID
        for (Contact c: contacts) {
            if (c.getContactId().equals(contactId)) {
                c.setFirstName(firstName);
                break;
            }
        }
    }
    // method to verify and update last name
    public void updateLastName(String contactId, String lastName){
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        // iterate through contacts to find contact ID
        for (Contact c: contacts) {
            if (c.getContactId().equals(contactId)) {
                c.setLastName(lastName);
            }
        }
    }
    // method to verify and update phone number
    public void updatePhone(String contactId, String phone){
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number");

        }
        // make sure all characters in phone are numbers
        for (char c : phone.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("Invalid phone number");
            }
        }
        // iterate through contacts to find contact ID
        for (Contact c: contacts) {
            if (c.getContactId().equals(contactId)) {
                c.setPhone(phone);
            }
        }
    }
    // method to verify and update address
    public void updateAddress(String contactId, String address){
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        // iterate through contacts to find contact ID
        for (Contact c: contacts) {
            if (c.getContactId().equals(contactId)) {
                c.setAddress(address);
            }
        }
    }
    public ArrayList<Contact> getContacts() {
        return contacts;
    }
}
