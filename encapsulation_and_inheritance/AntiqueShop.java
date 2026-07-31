package encapsulation_and_inheritance;

import java.util.Scanner;

public class AntiqueShop {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        ItemList itemList = new ItemList();
        byte choice = 0;
        do {
            System.out.println("1. Add a new Vase");
            System.out.println("2. Add a new Statue");
            System.out.println("3. Add a new Painting");
            System.out.println("4. Display all items");
            System.out.println("5. Find the items by the creator ");
            System.out.println("6. Display the list of vase items ");
            System.out.println("7. Quit");
            System.out.print("Input your choice: ");
            try {
                choice = Byte.parseByte(sc.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please enter an integer.");
            }


            switch (choice) {
                case 1:
                    Vase item = new Vase();
                    item.input();
                    if (itemList.addItem(item)) {
                        System.out.println("added");
                    }

                    break;
                case 2:
                    // Code here
                    Statue item2 = new Statue();
                    item2.input();
                    if (itemList.addItem(item2)) {
                        System.out.println("added");
                    }
                    break;
                case 3:
                    Painting item3 = new Painting();
                    item3.input();
                    if (itemList.addItem(item3)) {
                        System.out.println("added");
                    }
                    break;
                case 4:
                    if (itemList.isEmpty(itemList.list))
                        System.out.println("Empty list.\n");
                    else
                        itemList.displayAll();
                    break;
                case 5:
                    if (itemList.isEmpty(itemList.list)) {
                        System.out.println("Empty list. \n");
                    } else {
                        String creator;
                        System.out.print("Creator name: ");
                        creator = sc.nextLine();
                        System.out.println(itemList.findItem(creator).toString());
                    }
                    break;
                case 6:
                    // Code here
                    if (itemList.isEmpty(itemList.list)) {
                        System.out.println("Empty list.\n");
                    } else {
                        itemList.displayItemsByType("VASE");
                    }
            }//end switch
        } while (choice <= 6); //end while
    } //end class
}