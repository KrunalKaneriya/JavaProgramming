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

                    break;
                case 7:
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
        System.out.print("Enter Current Item Name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter Replacement Item Name: ");
        String newItem = scanner.nextLine();
        groceryList.modifyItem(itemName,newItem);
    }

    public static void removeItem() {
        System.out.print("Enter Item Name: ");
        String itemName = scanner.nextLine();
        groceryList.removeItem(itemName);
    }

    public static void searchItem() {
        System.out.print("Item to search for: ");
        String searchItem = scanner.nextLine();
        if(groceryList.onFile(searchItem)) {
            System.out.println("Found the search item " + searchItem + " in our list.");

        }
        else {
            System.out.println(searchItem + " not found in the list.");
        }
    }
}
