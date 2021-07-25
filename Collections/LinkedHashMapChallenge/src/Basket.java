import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Basket {
    private final String name;
    private final Map<StockItem,Integer>listofBasket;

    public Basket(String name) {
        this.name = name;
        this.listofBasket = new LinkedHashMap<>();
    }


    /* Function addToBasket Checking if item passed (StockItem) is not null and getting the number of quantity
    and after that putting the item with updated quantity and returning the inBasket (quantity of StockItem)
    */
//    public int addToBasket(StockItem item,int quantity) {
//        if(item!=null && quantity>0) {
//            //Returning the number of items by passing the item and getting the value
//            int inBasket = listofBasket.getOrDefault(item,0);
//            listofBasket.put(item,inBasket +quantity);
//            return inBasket;
//        }
//        return 0;
//    }

    //Function adding Items to Basket And it will be Reserved And Quantity will not be reduced
    public int addToBasket(StockItem item,int quantityReserved) {
        int inBasketStock = listofBasket.getOrDefault(item,0);
        if((item!=null) && (quantityReserved>0)) {
            listofBasket.put(item,inBasketStock + quantityReserved);
            return inBasketStock;
        }
        return 0;
    }

    public void clearBasket() {
        this.listofBasket.clear();
    }

    public int removeFromBasket(StockItem item,int quantity) {
        if((item!=null) &&(quantity>0)) {
            //Check if we already Have item in basket
            int inBasket = listofBasket.getOrDefault(item,0);
            int newQuantity = inBasket + quantity;

            if(newQuantity>0) {
                listofBasket.put(item,newQuantity);
                return quantity;
            } else if(newQuantity ==0){
                listofBasket.remove(item);
            }

        }
        return 0;
    }



    //Function returning the listOfBasket
    public Map<StockItem,Integer>itemsOfBasket() {
        return Collections.unmodifiableMap(listofBasket);
    }

    @Override
    public String toString() {
        String s = "\nShopping Basket " + name + " contains" + ((listofBasket.size() == 1) ? " Item " : " Items ") + "\n";
        double totalCost = 0.0;
        for(Map.Entry<StockItem,Integer>item: listofBasket.entrySet()) {
            s = s + item.getKey() + ", " + item.getValue() + " Purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total Cost " + totalCost;
     }
}
