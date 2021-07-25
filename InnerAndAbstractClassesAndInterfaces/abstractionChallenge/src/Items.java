public abstract class Items {
    Items rightLink = null;
    Items leftLink = null;

    String item;
    public Items(String item) {
        this.item = item;
    }

    abstract Items moveNextItem();
    abstract Items movePreviousItem();

    abstract Items setNextItem(Items items);
    abstract Items setPreviousItem(Items items);

    abstract int compareItem(Items items);

    public String getItem() {
        return item;
    }
}