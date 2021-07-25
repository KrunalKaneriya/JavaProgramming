import java.util.ArrayList;
import java.util.Scanner;

class MobilePhone {
    private ArrayList<Contacts>contactsArrayList = new ArrayList<Contacts>();
    private Scanner scanner= new Scanner(System.in);
    public MobilePhone() {
        this.contactsArrayList = new ArrayList<Contacts>();
    }

    public void addContact(String contactName,String contactNumber) {
        Contacts contact = new Contacts(contactName,contactNumber);
        addContact(contact);
    }

    private boolean addContact(Contacts contact) {
        if(findContacts(contact)>0) {
            System.out.println("Contact Already Exists..");
            return false;
        }
        else {
            contactsArrayList.add(contact);
            System.out.println("Contact Added..");
            return true;
        }
    }

    public int findContacts(Contacts contact) {
        return contactsArrayList.indexOf(contact);
    }

    public int findContacts(String contactName) {
        for(int i=0;i<contactsArrayList.size();i++) {
            Contacts contact = this.contactsArrayList.get(i);
            if(contact.getContactName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public void printContact() {
        if(contactsArrayList.size() <=0) {
            System.out.println("No Contacts Found..");
        }else {
            System.out.println("There are " + contactsArrayList.size() + " contacts...");
            for (int i = 0; i < contactsArrayList.size(); i++) {
                System.out.println("Name: " + contactsArrayList.get(i).getContactName() + "\t Number: " + contactsArrayList.get(i).getContactNumber());
            }
        }
    }

    public void updateContact(String contactName) {
        int position = findContacts(contactName);
        if(position>=0) {
            System.out.println("Found Contact Named: "+ contactsArrayList.get(position).getContactName() + "\tNumber: "+ contactsArrayList.get(position).getContactNumber());
            System.out.print("Enter The New Name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter The New Number: ");
            String newNumber = scanner.nextLine();
            contactsArrayList.set(position,Contacts.returnContact(newName,newNumber));
        }
        else {
            System.out.println("Contact Not Found........");
        }
    }

    public boolean removeContact(String contactName) {
        int position = findContacts(contactName);
        if(position>=0) {
            System.out.println("Found Contact Name: "+ contactsArrayList.get(position).getContactName() + "\tNumber: "+ contactsArrayList.get(position).getContactNumber());
            contactsArrayList.remove(position);
            System.out.println("The Contact Has Been Deleted Successfully....");
            return true;
        }
        else {
            System.out.println("Contact Not Found....");
            return false;
        }
    }

    public void printIndex() {
        System.out.println("1. For Printing The Menu.");
        System.out.println("2. For Adding The Contact.");
        System.out.println("3. For Printing The Contact.");
        System.out.println("4. For Removing The Contact");
        System.out.println("5. For Searching The Contact");
        System.out.println("6. For Updating The Contact.");
        System.out.println("7. To Exit.");
    }

    public void printlocation(int position) {
        if(position>=0) {
            System.out.println("Found Contact...");
            System.out.println("Name: " + contactsArrayList.get(position).getContactName());
            System.out.println("Number: " + contactsArrayList.get(position).getContactNumber());
        }
        else {
            System.out.println("No Contact Found...");
        }
    }


}