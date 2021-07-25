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

    public void modifyItem(int position,String newItem) {
        groceryList.set(position,newItem);
        System.out.println("Grocery Item " + (position+1) + " Has Been Modified");
    }

    public void removeItem(int position) {
        String item = groceryList.get(position);
        groceryList.remove(position);
    }

    public String findItem(String searchItem) {
//        boolean exists = groceryList.contains(searchItem);
        int position = groceryList.indexOf(searchItem);
        if(position >= 0) {
            return groceryList.get(position);
        }else {
            return null;
        }
    }
}
