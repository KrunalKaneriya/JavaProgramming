public class StockItem implements Comparable<StockItem>{
    private final String name;
    private double price;
    private int quantityStock = 0;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0; //or here but you wouldn't do normally both.
    }

    //Second constructor if we want to set the quantity directly
    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStock;
    }

    //function to set the price of the stock
    public void setPrice(double price) {
        if(price>0.0) {
            this.price = price;
        }
    }

    //function to add or to remove the stock quantity
    public void adjustStock(int quantityStock) {
        int newQuantity = this.quantityStock + quantityStock;
        if(newQuantity>=0) {
            this.quantityStock = newQuantity;
        }
    }

    //equals function comparing the stocks name
    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering Stockitem.equals");
        if(obj == this){
            return true;
        }
        if((obj == null) || (obj.getClass()!=this.getClass())){
            return false;
        }
        String objName = ((StockItem)obj).name;
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 30;
    }

    //compareTo function comparing the stocks name via internal String compare method
    @Override
    public int compareTo(StockItem obj) {
        System.out.println("Entering Stockitem.compareTo");
        if(this == obj) {
            return 0;
        }
        if(obj!=null) {
            return this.name.compareTo(obj.name);
        }
        throw new NullPointerException();
        //we have to assume that compare To returning int shouldn't
        //return null values.
    }

    @Override
    public String toString() {
        return this.name + " : Price " + this.price;
    }
}
