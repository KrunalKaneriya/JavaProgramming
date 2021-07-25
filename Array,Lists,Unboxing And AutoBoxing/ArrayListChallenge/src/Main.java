import java.util.Scanner;

public class Main {
    private static MobilePhone m1 = new MobilePhone();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        boolean quit = false;
        printIndex();
        while(!quit) {
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
                    printContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchContact();
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
        m1.printIndex();
    }

    public static void addContact() {
        System.out.print("Enter The Contact Name To Add: ");
        scanner.nextLine();
        String contactName = scanner.nextLine();

        System.out.print("Enter The Contact Number: ");
        String contactNumber = scanner.nextLine();

        m1.addContact(contactName,contactNumber);
    }

    public static void printContact() {
        m1.printContact();
    }

    public static void removeContact() {
        System.out.print("Enter The Contact Name to remove: ");
        scanner.nextLine();
        String removeName = scanner.nextLine();
        m1.removeContact(removeName);
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
        m1.updateContact(oldName);
    }
}