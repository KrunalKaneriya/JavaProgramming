import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();
    public static void main(String[] args) {

        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.println("Enter Your Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceries();
                    break;
                case 2:
                    additem();
                    break;
                case 3:
                    modify();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchItem();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }

    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To Print Choice Options.");
        System.out.println("\t 1 - To Print the List.");
        System.out.println("\t 2 - To add an Item In List.");
        System.out.println("\t 3 - To modify an item in list.");
        System.out.println("\t 4 - To remove an item from list.");
        System.out.println("\t 5 - To search for an item in list.");
        System.out.println("\t 6 - to quit the application.");
    }

    public static void additem() {
        System.out.print("Please Enter Grocery Item: ");
        groceryList.addGroceries(scanner.nextLine());
    }

    public static void modify() {
        System.out.print("Enter Item Number: ");
        int itemNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Replacement Item ");
        String newItem = scanner.nextLine();
        groceryList.modifyItem(itemNumber-1,newItem);
    }

    public static void removeItem() {
        System.out.print("Enter Item Number: ");
        int itemNumber = scanner.nextInt();
        scanner.nextLine();
        groceryList.removeItem(itemNumber-1);
    }

    public static void searchItem() {
        System.out.print("Item to search for: ");
        String searchItem = scanner.nextLine();
        if(groceryList.findItem(searchItem) != null) {
            System.out.println("Found the search item " + searchItem + " in our list.");

        }
        else {
            System.out.println(searchItem + " not found in the list.");
        }
    }
}
