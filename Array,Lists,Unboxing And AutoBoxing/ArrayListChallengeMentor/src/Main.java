import java.util.Scanner;

public class Main {
    private static MobilePhone m1 = new MobilePhone();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean quit = false;
        printIndex();
        while (!quit) {
            System.out.print("Enter Your Choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    printIndex();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    m1.printContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    updateContact();
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }

    }


    public static void printIndex() {
        System.out.println("1. For Printing The Menu.");
        System.out.println("2. For Adding The Contact.");
        System.out.println("3. For Printing The Contact.");
        System.out.println("4. For Removing The Contact");
        System.out.println("5. For Searching The Contact");
        System.out.println("6. For Updating The Contact.");
        System.out.println("7. To Exit.");
    }

    private static void addContact() {
        System.out.print("Enter The Contact Name To Add: ");
        scanner.nextLine();
        String contactName = scanner.nextLine();

        System.out.print("Enter The Contact Number: ");
        String contactNumber = scanner.nextLine();
        Contacts newContact = Contacts.returnContact(contactName, contactNumber);
        if (m1.addContact(newContact)) {
            System.out.println("New Contact Added..");
        } else {
            System.out.println("Cannot Add Contact.\nAlready Exists on File.");
        }
    }


    public static void searchContact() {
        System.out.print("Enter The Contact Name to Search: ");
        scanner.nextLine();
        String searchName = scanner.nextLine();
        int position = m1.findContacts(searchName);
        m1.printlocation(position);
    }

    public static void updateContact() {
        System.out.print("Enter The Old Contact Name: ");
        scanner.nextLine();
        String oldName = scanner.nextLine();
        Contacts existingRecord = m1.queryContacts(oldName);
        if (existingRecord == null) {
            System.out.println("Contact Not Found...");
            return;
        }

        System.out.println("Enter new Contact Name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new Phone Number:");
        String newNumber = scanner.nextLine();
        Contacts newContact = Contacts.returnContact(newName, newNumber);
        if (m1.updateContact(existingRecord, newContact)) {
            System.out.println("Successfully Updated record");
        } else {
            System.out.println("Error Updating record");
        }
    }

    public static void removeContact() {
        System.out.print("Enter The Old Contact Name: ");
        scanner.nextLine();
        String oldName = scanner.nextLine();
        Contacts existingRecord = m1.queryContacts(oldName);
        if (existingRecord == null) {
            System.out.println("Contact Not Found...");
            return;
        }

        if (m1.removeContact(existingRecord)) {
            System.out.println("Successfully Deleted.");
        } else {
            System.out.println("Error Deleting Record");
        }
    }

    public static void queryContact() {
        System.out.print("Enter The Old Contact Name: ");
        scanner.nextLine();
        String oldName = scanner.nextLine();
        Contacts existingRecord = m1.queryContacts(oldName);
        if (existingRecord == null) {
            System.out.println("Contact Not Found...");
            return;
        }

        System.out.println("Name: " + existingRecord.getContactName() + "\t Phone Number: "+ existingRecord.getContactNumber());

    }
}