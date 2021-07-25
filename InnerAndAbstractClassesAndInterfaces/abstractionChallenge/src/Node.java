public class Node extends Items {


    public Node(String item) {
        super(item);
    }

    @Override
    Items moveNextItem() {
        return this.rightLink;
    }

    @Override
    Items movePreviousItem() {
        return this.leftLink;
    }

    @Override
    Items setNextItem(Items items) {
        this.rightLink = items;
        return rightLink;
    }

    @Override
    Items setPreviousItem(Items items) {
        this.leftLink = items;
        return leftLink;
    }

    @Override
    int compareItem(Items items) {
        if (item != null) {
            return super.getItem().compareTo(items.getItem());
        } else {
            return -1;
        }

    }

}