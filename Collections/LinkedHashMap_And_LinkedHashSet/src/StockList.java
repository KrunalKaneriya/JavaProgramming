import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String,StockItem>list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    /* what this function is doing that it will accept a Item as Argument and it will check if this is not null on line 13 and if it is not null then
    * it will check that the item that was passed was already present on list Map and if it is then it will be assigned to inStock else it will
    * be null and then if inStock != null (it founded the existing entry of item passed) then it will call the adjust Stock function of the item
    * passed and it will add the quantity of the existing object. So now we have the quantity of item passed as argument and the existing Stock
    * of the old entry assigned to inStock and we will put the edited entry to Map and we will return the Stock of the item and return 0 to indicate
    * success of the function.*/
    public int addStock (StockItem item){
        if(item!=null){
            //Check if already item in list of Items
            StockItem inStock = list.get(item.getName());
            //If there are already stocks of item, adjust the quantity and update the list with updated Quantity
            if(inStock!=null) {
                item.adjustStock(inStock.quantityInStock());
            }
            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        return 0;
    }

/*
    public int addStock(StockItem item) {
        if(item != null) {
            StockItem inStock = list.getOrDefault(item.getName(),item);
            if(inStock != item) { //Comparing that inStock != item means that the Argument passed is not assigned to inStock so it means that existing
            entry was found in list.
                item.adjustStock(inStock.getQuantityStock());
            }
            list.put(item.getName(),item);
        }
        return 0;
    }
*/

    /*The sellStock function takes two parameters (item name and quantity) and firstly it will get the existing entry in list and if it is not found then
    * null will be assigned to inStock else old entry will be assigned and in the next condition we are checking that the entry is not null (existing entry
    * was found) and inStock quantitu is greater than or equals to the quantity passed and quantity > 0 and after that we are calling adjustStock function
    * from inStock and we are passing negative quantity so (int newQuantity = this.Quantity + quantity passed (-) so it will be - not +) and we are
    * returning the quantity. */
    public int sellStock(String item,int quantity) {
        //here we are using defaultValue as null because inOrder to sell the Stock the stock needs to be there.
        StockItem inStock = list.getOrDefault(item,null);
        if(inStock.quantityInStock() == 0) {
            System.out.println("\n" + item + " Stock " + "is not Available");
        }
        if((inStock!=null) && (inStock.quantityInStock() >= quantity) && (quantity>0)) {
            inStock.adjustStock(-quantity);
            return quantity;
        }
        return 0;
    }

    public StockItem getStock(String name) {
        return list.get(name); //it will return null if not found
//        StockItem inStock = list.get(name);
//        if(inStock != null) {
//            return inStock;
//        }
//        return null;
    }
    public Map<String,StockItem>Items() {
        //It will return the Map but the Map will be read Only and we cannot do any Operations with it and if we do then it will throw Exception
        return Collections.unmodifiableMap(list);
    }

    public Map<String,Double> pricesList() {
        Map<String,Double>prices= new LinkedHashMap<>();
        for(Map.Entry<String,StockItem> item: list.entrySet()) {
            prices.put(item.getKey(),item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }


    @Override
    public String toString() {
        String s = "\nStockList\n";
        double totalCost = 0.0;
        for(Map.Entry<String,StockItem> item: list.entrySet()) {
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();
            s = s + stockItem + ". There are " + stockItem.quantityInStock() + " in stock. Value of Items: ";
            s = s + String.format("%.2f",itemValue) + "\n";
            totalCost+=itemValue;
        }
        return s + "Total Stock Value " + String.format("%.3f",totalCost);
    }
}
