import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String>groceryList = new ArrayList<String>();


    public void addGroceries(String item) {
        groceryList.add(item);


    }


    public void printGroceries() {
        System.out.println("You Have = " + groceryList.size() + " Items in Your List.");
        for (int i=0;i<groceryList.size();i++) {
            System.out.println((i+1) + ". "+ groceryList.get(i));
        }
    }


    public void modifyItem(String itemName,String newItem) {
        int position = findItem(itemName);
        if(position>=0) {
            modifyItem(position,newItem);
        }
    }

    private void modifyItem(int position,String newItem) {
        groceryList.set(position,newItem);
        System.out.println("Grocery Item " + (position+1) + " Has Been Modified");
    }

    public void removeItem(String Item) {
        int position = findItem(Item);
        if(position>=0) {
            removeItem(position);
        }
    }
    private void removeItem(int position) {
        groceryList.remove(position);
    }

    private int findItem(String searchItem) {
        return groceryList.indexOf(searchItem);
//        boolean exists = groceryList.contains(searchItem);
//        int position = groceryList.indexOf(searchItem);
//        if(position >= 0) {
//            return groceryList.get(position);
//        }else {
//            return null;
//        }
    }

    public boolean onFile(String searchItem) {
        int position = findItem(searchItem);
        if(position>=0) {
            return true;
        }
        return false;
    }

    public void processArrayList() {

         ArrayList<String>newArray = new ArrayList<String>(groceryList);
         ArrayList<String>nextArray = new ArrayList<String>();
         newArray.addAll(groceryList);

        String[] myArray = new String[groceryList.size()];
        myArray = groceryList.toArray(myArray);
    }

}
