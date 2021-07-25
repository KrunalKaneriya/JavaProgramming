import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ConcurrentNavigableMap;

class MobilePhone {
    private ArrayList<Contacts>contactsArrayList = new ArrayList<Contacts>();
    private Scanner scanner= new Scanner(System.in);
    public MobilePhone() {
        this.contactsArrayList = new ArrayList<Contacts>();
    }

    public void addContact(String contactName,String contactNumber) {
//        Contacts contact = new Contacts(contactName,contactNumber);
//        addContact(contact);
        addContact(Contacts.returnContact(contactName,contactNumber));
    }

    public boolean addContact(Contacts contact) {
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

    private int findContacts(Contacts contact) {
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

    public String queryContact(Contacts contact) {
        if(findContacts(contact) >=0) {
            return contact.getContactName();
        }
        return null;
    }

    public Contacts queryContacts (String name) {
        int position = findContacts(name);
        if(position>=0) {
            return this.contactsArrayList.get(position);
        }
        return null;
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

    public boolean updateContact(Contacts oldcontact,Contacts newcontact) {
        int position = findContacts(oldcontact);
        if(position>=0) {
           this.contactsArrayList.set(position,newcontact);
            System.out.println(oldcontact.getContactName() + " was replaced with " + newcontact.getContactName());
            return true;
        }
        else {
            System.out.println("Contact Not Found........");
            return false;
        }
    }

    public boolean removeContact(Contacts contact) {
        int position = findContacts(contact);
        if(position<=0) {
            System.out.println("Contact Not Found....");
            return false;
        }
        else {
            System.out.println("Found Contact Name: "+ contactsArrayList.get(position).getContactName() + "\tNumber: "+ contactsArrayList.get(position).getContactNumber());
            contactsArrayList.remove(position);
            System.out.println("The Contact Has Been Deleted Successfully....");
            return true;
        }
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