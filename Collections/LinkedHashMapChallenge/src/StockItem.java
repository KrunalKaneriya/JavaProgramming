public class StockItem implements Comparable<StockItem>{
    private final String name;
    private double price;
    private int quantityStock = 0;
    private int reservedStock = 0;

    //Constructor that accepts name and price of Item and sets Quantity to 0
    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0; //or here but you wouldn't do normally both.
    }

    //Constructor Accepts three arguments of name,price,quantity of the item.
    public StockItem(String name, double price, int reservedStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;
        this.reservedStock = reservedStock;
    }

    //Item Name Getter
    public String getName() {
        return name;
    }

    //Item Price Getter
    public double getPrice() {
        return price;
    }

    //Item Quantity Getter that returns the quantity after the reserved Stock
    public int getQuantityStock() {
        return quantityStock - reservedStock ;
    }

    public int getReservedStock() {
        return reservedStock;
    }

    //Function setting Price of Item
    public void setPrice (double price) {
        if(price>0) {
            this.price = price;
        }
    }

    public int availableQuantity() {
        return quantityStock - reservedStock;
    }

    public int reserveStock(int quantity) {
            if(quantity <= availableQuantity()) {
                reservedStock += quantity;
                return quantity;
            }
            return 0;
    }

    public int unreserveStock(int quantity) {
        if(quantity <= reservedStock) {
            reservedStock-=quantity;
            return quantity;
        }
        return 0;
    }

    public int finaliseStock(int quantity) {
        if(quantity <=reservedStock) {
            quantityStock -=quantity;
            reservedStock -=quantity;
            return quantity;
        }
        return 0;
    }


    //Function to add or to remove ItemStock
    public void adjustStock(int numberOfItems) {
        int newQuantity = this.quantityStock + numberOfItems;
        if(newQuantity>=0) {
            this.quantityStock = newQuantity;
        }
    }

    //equals Function Comparing the Stock Name
    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.Equals() Function");
        if(obj == this) { //if object passed is same with calling function then
            return true; //return true
        }
        if((obj == null) || (obj.getClass()!=this.getClass())) {
            return false; //If object is null or obj class is not same with calling function class then return false
        }
        String objName = ((StockItem)obj).name;
        return this.name.equals(objName);
    }

    //HashCode function returning the hashCode + 20
    @Override
    public int hashCode() {
        return this.name.hashCode() + 20;
    }

    //CompareTo function of Comparator Interface to Compare the Names of Stock
    @Override
    public int compareTo(StockItem obj) {
//        System.out.println("Entering StockItem CompareTo() Function");
        if(this == obj) { //If Both Objects are same then return 0
            return 0;
        }
        if(obj!=null) { //If Object is not null then
            return this.name.compareTo(obj.name); //use the String compareTo function to add Objects in Proper Order
        }
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name  + " : Price " + this.price + " Reserved " + this.reservedStock;
    }
}
