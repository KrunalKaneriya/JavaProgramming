import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();
    public static void main(String[] args) {
        System.out.println("****************************");
        StockItem temp = new StockItem("Bread",0.86,100);
        stockList.addStock(temp);

        temp = new StockItem("Cake",1.10,7);
        stockList.addStock(temp);

        temp = new StockItem("Car",21.10,2);
        stockList.addStock(temp);

        temp = new StockItem("Chair",0.50,10);
        stockList.addStock(temp);
        temp.adjustStock(4000);

        temp = new StockItem("Cup",0.50,200);
        stockList.addStock(temp);
//        temp = new StockItem("Cup",2,7);
//        stockList.addStock(temp);
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

        System.out.println(stockList);

//        for(String s: stockList.Items().keySet()) {
//            System.out.println(s);
//        }

        Basket krunalBasket = new Basket("Krunal");
        sellItem(krunalBasket,"Car",1);
        System.out.println(krunalBasket);

        sellItem(krunalBasket,"Car",1);
        System.out.println(krunalBasket);

        sellItem(krunalBasket,"Car",1);
        System.out.println(krunalBasket);

        sellItem(krunalBasket,"Spanner",22);
        System.out.println(krunalBasket);

        sellItem(krunalBasket,"Juice",4);
        sellItem(krunalBasket,"Cup",12);
        sellItem(krunalBasket,"Bread",1);
        System.out.println(krunalBasket);
        System.out.println(stockList);

//        temp = new StockItem("Pen",4.5);
//        stockList.Items().put(temp.getName(), temp);

        for(Map.Entry<String,Double>price:stockList.pricesList().entrySet()) {
            System.out.println(price.getKey() + " costs " + price.getValue());
        }
    }

    public static int sellItem(Basket basket,String item,int quantity) {
        //Retrieve the item from the Stock List first
            StockItem stockItem = stockList.getStock(item);
            if(stockItem==null) {
                System.out.println("We don't sell " + item);
                return 0;
            }
            if(stockList.sellStock(item,quantity)!=0) {
                basket.addToBasket(stockItem,quantity);
                return quantity;
            }
            return 0;
    }

}
