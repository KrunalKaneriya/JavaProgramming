public class MyLinkedList implements NodeList{

    private Items root = null;

    public MyLinkedList(Items root) {
        this.root = root;
    }


    @Override
    public Items getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(Items newitem) {
        if(this.root == null) {
            this.root = newitem;
            return true;
        }

        Items currentItem = this.root;
        while(currentItem != null) {
            int comparision = (currentItem.compareItem(newitem));
            if(comparision<0) {
                //New item is greater so move right if possible.
                if(currentItem!=null) {
                    currentItem = currentItem.moveNextItem();
                } else {
                    currentItem.setNextItem(newitem);
                    newitem.setPreviousItem(currentItem);
                    //currentItem.setNextItem(newitem).setPreviousItem(currentItem);
                    return true;
                }
            } else if(comparision>0) {
                // newItem is less insert it before
                if(currentItem.movePreviousItem()!=null) {
//                    currentItem.movePreviousItem().setNextItem(newitem).setPreviousItem(currentItem.movePreviousItem);
                    currentItem.movePreviousItem().setNextItem(newitem);
                    newitem.setPreviousItem(currentItem.movePreviousItem());
                    newitem.setNextItem(currentItem);
                    currentItem.setPreviousItem(newitem);
                } else {
                    //the node with a previous is a root so set the newitem as root
                    newitem.setNextItem(this.root);
                    this.root.setPreviousItem(newitem);
                    this.root = newitem;
                    return true;
                }
            } else {
                System.out.println(newitem.getItem() + " is already present. Not Added");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(Items items) {
        return false;
    }

    @Override
    public void traverse(Items items) {

    }
}
