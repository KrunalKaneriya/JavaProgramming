import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String,StockItem>list; //Map Storing the Item name and Items in List

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    /* what this function is doing that it will accept a Item as Argument and it will check if this is not null on line 13 and if it is not null then
     * it will check that the item that was passed was already present on list Map and if it is then it will be assigned to inStock else it will
     * be null and then if inStock != null (it founded the existing entry of item passed) then it will call the adjust Stock function of the item
     * passed and it will add the quantity of the existing object. So now we have the quantity of item passed as argument and the existing Stock
     * of the old entry assigned to inStock and we will put the edited entry to Map and we will return the Stock of the item and return 0 to indicate
     * success of the function.*/
    public int addStock(StockItem item) {
        if(item!=null) {
            //Check if already item in list of Items
            StockItem inStock = list.get(item.getName());
            //If there are already stocks of item, adjust the quantity and update the list with updated Quantity
            if(inStock!=null) {
                item.adjustStock(inStock.availableQuantity());

            }
            //Insert the updated item to Map
            list.put(item.getName(),item);
            return item.getQuantityStock();
        }
        return 0;
    }

    /*The sellStock function takes two parameters (item name and quantity) and firstly it will get the existing entry in list and if it is not found then
     * null will be assigned to inStock else old entry will be assigned and in the next condition we are checking that the entry is not null (existing entry
     * was found) and inStock quantity is greater than or equals to the quantity passed and quantity > 0 and after that we are calling adjustStock function
     * from inStock and we are passing negative quantity so (int newQuantity = this.Quantity + quantity passed (-) so it will be - not +) and we are
     * returning the quantity. */
    public int sellStock(String item,int quantity) {
//        StockItem inStock = list.getOrDefault(item,null);
//        //if the Quantity of the Item(StockItem) gets 0 then it will print.
//        if(inStock.getQuantityStock() == 0) {
//            System.out.println("\n" + item + " Stock " + "is Not Available");
//        }
//        if((inStock!=null) && (inStock.getQuantityStock() >= quantity) && (quantity>0)) {
//            inStock.adjustStock(-quantity);
//            return quantity;
//        }
//        return 0;
        StockItem inStock = list.get(item);
        if((inStock!=null) &&(quantity>0)) {
            return inStock.finaliseStock(quantity);
        }
        return 0;
    }

    public int reserveStock(String item,int quantity) {
        StockItem inStock = list.get(item);
        if((inStock!=null) && (quantity >0)) {
            return inStock.reserveStock(quantity);
        }
        return 0;
    }

    public int unreserveStock(String item,int quantity) {
        StockItem inStock = list.get(item);
        if((inStock!=null) && (quantity >0)) {
            return inStock.unreserveStock(quantity);
        }
        return 0;
    }

    //StockList Getter returning the individial Item of StockItem from Map
    public StockItem getStock(String name) {
        return list.get(name);
    }

    //StockList getter returning the Map of StockItems
    public Map<String,StockItem>Items() {
        return Collections.unmodifiableMap(this.list);
    }

    //Function returning the Map Of the Items and Their Name And their Prices
    public Map<String,Double>priceList() {
        Map<String,Double>prices = new LinkedHashMap<>();
        for(Map.Entry<String,StockItem>item: list.entrySet()) {
            prices.put(item.getKey(),item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    //ToString Function of StockList returning the List of Stocks

    @Override
    public String toString() {
        String s= "\nStockList\n";
        double totalCost = 0.0;
        for(Map.Entry<String,StockItem>item:list.entrySet()) {
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.getQuantityStock();
            s = s + stockItem + ". There are " + stockItem.getQuantityStock() + " in stock." + " And " +stockItem.getReservedStock() +  " in Reserve. Value of Items: $";
            s = s + String.format("%.2f",itemValue) + "\n";
            totalCost+=itemValue;
        }
        return s + "Total Stock Value: $" + String.format("%.3f",totalCost);
    }
}
