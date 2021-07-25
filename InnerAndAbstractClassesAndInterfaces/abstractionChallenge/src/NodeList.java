public interface NodeList {
    Items getRoot();
    boolean addItem(Items items);
    boolean removeItem(Items items);
    void traverse(Items items);
}
