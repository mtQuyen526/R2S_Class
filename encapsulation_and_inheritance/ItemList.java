package encapsulation_and_inheritance;

public class ItemList {
    Item[] list; // an array to store all items
    int numOfItem; // to store the number of items that added to the list
    final int MAX = 100; // is the size of the array

    public ItemList() {
        list = new Item[MAX];
    }

    /* This method add an Item object to the list
input: a new item that needs to add
output: return true/false
*/
    public boolean addItem(Item item) {
        if (item == null || numOfItem >= MAX) {
            return false;
        }

        list[numOfItem] = item;
        numOfItem++;

        return true;
    }

    // this method prints out information of all items
    public void displayAll() {
        // Code here
        if (isEmpty(list)) {
            System.out.println("The list is empty.");
            return;
        }
        for (Item item : list) {
            if (item != null)
                System.out.println(item);
        }
    }

    /* this method finds the item by its creator
return the item that is found of the first occurrence.
*/
    public Item findItem(String creator) {
        // Code here
        if (isEmpty(list)) {
            System.out.println("Empty list");
            return null;
        }
        for (Item item : list) {
            if (item.creator.equals(creator.trim()))
                return item;
        }
        System.out.println("Information not found.");
        return null;
    }

    public Item findItemById(String id) {
        if (isEmpty(list)) {
            System.out.println("Empty list");
            return null;
        }
        for (Item item : list) {
            if (item.id.equals(id.trim()))
                return item;
        }
        System.out.println("Information not found.");
        return null;
    }

    /* this method updates the item at the specified id in this list
input: the id you wish to update
*/
    public boolean updateItem(String id) {
        // Code here
        if (findItemById(id) == null) {
            return false;
        }else
            findItemById(id).updateItem();
        return true;
    }


    // this method prints out all items that belong to the given type in the list.
    public void displayItemsByType(String type) {
        if (type.equals("VASE")) {
            for (int i = 0; i < numOfItem; i++) {
                if (list[i] instanceof Vase) {
                    System.out.println(list[i]);
                }
            }
        } else if (type.equals("STATUE")) {
            for (int i = 0; i < numOfItem; i++) {
                if (list[i] instanceof Statue) {
                    System.out.println(list[i]);
                }
            }
        } else {
            for (int i = 0; i < numOfItem; i++) {
                if (list[i] instanceof Painting) {
                    System.out.println(list[i]);
                }
            }
        }
    }

    public boolean isEmpty(Item[] list){
        for (Item item: list)
            if(item !=null)
                return false;
        return true;
    }
}
