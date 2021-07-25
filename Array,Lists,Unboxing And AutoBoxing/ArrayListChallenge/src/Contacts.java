import java.util.ArrayList;

public class Contacts {
    private String contactName;
    private String  ContactNumber;

    public Contacts(String contactName, String contactNumber) {
        this.contactName = contactName;
        this.ContactNumber = contactNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }

    public static Contacts returnContact(String contactName, String contactNumber) {
        return new Contacts(contactName,contactNumber);
    }
}
