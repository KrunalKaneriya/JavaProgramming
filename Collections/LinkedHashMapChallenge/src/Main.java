/*

Modify the program so that adding items to the shopping basket doesn't
actually reduce the stock count but, instead, reserves the requested
number of items.

You will need to add a "reserved" field to the StockItem class to store the
number of items reserved.

Items can continue to be added to the basket, but it should not be possible to
reserve more than the available stock of any item. An item's available stock
is the stock count less the reserved amount.

The stock count for each item is reduced when a basket is checked out, at which
point all reserved items in the basket have their actual stock count reduced.

Once checkout is complete, the contents of the basket are cleared.

It should also be possible to "unreserve" items that were added to the basket
by mistake.

The program should prevent any attempt to unreserve more items than were
reserved for a basket.

Add code to Main that will unreserve items after they have been added to the basket,
as well as unreserving items that have not been added to make sure that the code
can cope with invalid requests like that.

After checking out the baskets, display the full stock list and the contents of each
basket that you created.

 */

import java.util.Map;

public class Main {

    private final static StockList stockList = new StockList();
    public static void main(String[] args) {

        StockItem temp = new StockItem("Bread",0.86,100);
        stockList.addStock(temp);

        temp = new StockItem("Cake",1.10,7);
        stockList.addStock(temp);

        temp = new StockItem("Car",21.10,2);
        stockList.addStock(temp);

        temp = new StockItem("Chair",0.50,10);
        stockList.addStock(temp);

        temp = new StockItem("Cup",0.50,200);
        stockList.addStock(temp);
        temp = new StockItem("Cup",2,7);
        stockList.addStock(temp);
        temp = new StockItem("Door",72.95,4);
        stockList.addStock(temp);

        temp = new StockItem("Juice",2.50,36);
        stockList.addStock(temp);

        temp = new StockItem("Phone",100,5);
        stockList.addStock(temp);

        temp = new StockItem("Towel",2.40,80);
        stockList.addStock(temp);

        temp = new StockItem("Vase",8.76,46);
        stockList.addStock(temp);
//        stockList.sellStock("Chair",10);
        System.out.println(stockList);

//        Creating new Basket

        Basket krunalBasket = new Basket("Krunal's Basket");
        sellItem(krunalBasket,"Car",1);
        System.out.println(krunalBasket);

        sellItem(krunalBasket,"Car",1);
        System.out.println(krunalBasket);

        sellItem(krunalBasket,"Spanner",22);
        System.out.println(krunalBasket);

        sellItem(krunalBasket,"Juice",4);

        sellItem(krunalBasket,"Cup",12);
        sellItem(krunalBasket,"Bread",51);
        System.out.println(krunalBasket);


    }


    public static int sellItem(Basket basket,String item,int quantity) {
        //Retrieve the item from the Stock List first
        StockItem stockItem = stockList.getStock(item);
        int currentStockQuantity = stockItem.getQuantityStock();
        if(stockItem==null) {
            System.out.println("\nWe don't sell " + item);
            return 0;
        }

        //If the Passed Quantity is greater than inStock then assign the all Available Stock to Quantity and pass to sellStock
        if(quantity > currentStockQuantity) {
            System.out.println("Warning.. " + item + " Stock is Less Than the Stock You Require");
            quantity = currentStockQuantity;
        }
        if(stockList.reserveStock(item,quantity)!=0) {
            return basket.addToBasket(stockItem,quantity);
        }
        return 0;
    }

    public static int removeItem(Basket basket,String item,int quantity) {
        //Retrieve the item from the Stock List first
        StockItem stockItem = stockList.getStock(item);
        int currentStockQuantity = stockItem.getQuantityStock();
        if(stockItem==null) {
            System.out.println("\nWe don't sell " + item);
            return 0;
        }

        //If the Passed Quantity is greater than inStock then assign the all Available Stock to Quantity and pass to sellStock
        if(basket.removeFromBasket(stockItem,quantity)==quantity) {
            return stockList.unreserveStock(item,quantity);
        }
        return 0;
    }

    public static void checkOut(Basket basket) {
        for(Map.Entry<StockItem,Integer>item : basket.itemsOfBasket().entrySet()) {
            stockList.sellStock(item.getKey().getName(),item.getValue());
        }
        basket.clearBasket();
    }

}
