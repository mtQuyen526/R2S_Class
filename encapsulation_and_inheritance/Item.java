package encapsulation_and_inheritance;

import java.util.Scanner;

public class Item {
    // declare properties
    protected String id; // Not null and unique
    protected int value; // the price of a Item (>=0)
    protected String creator; // the creator who creates the item (is not empty)

    // constructors
    public Item() {
    }

    // getters,setters: you is required to add more code to get/set fields of a Item object


    public String getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public String getCreator() {
        return creator;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    // this method is used to input all fields of a Item object
    public void input() {
        //use Scanner class to input fields
        System.out.println("Input information item:  ");
        Scanner sc = new Scanner(System.in);
        System.out.print("id: ");
        String id;
        id = sc.nextLine().trim();
        while (id.isEmpty()) {
            System.out.println("Invalid input. Please try again.");
            System.out.print("id: ");
            id = sc.nextLine().trim();
        }


        int value;

        while (true) {
            System.out.print("Value: ");

            try {
                value = Integer.parseInt(sc.nextLine().trim());

                if (value >= 0) {
                    break;
                }

                System.out.println("Value must be greater than or equal to 0.");
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }


        System.out.print("Creator: ");
        String creator;
        creator = sc.nextLine().trim();
        while (creator.isEmpty()) {
            System.out.println("Invalid input. Please try again.");
            System.out.print("Creator: ");
            creator = sc.nextLine().trim();
        }

        this.id = id;
        this.value = value;
        this.creator = creator;

    }

    // this method returns a string that includes id, value, creator of a Item object
    public String toString() {
        return String.format("ID: %s, Value: %d, Creator: %s", id, value, creator);
    }

    public boolean updateItem(){
        System.out.println("Update information id: "+this.id);

        Scanner sc = new Scanner(System.in);
        int value;

        while (true) {
            System.out.print("New value: ");

            try {
                value = Integer.parseInt(sc.nextLine().trim());

                if (value >= 0) {
                    break;
                }

                System.out.println("Value must be greater than or equal to 0.");
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
        System.out.print("New creator: ");
        String creator;
        creator = sc.nextLine().trim();
        while (creator.isEmpty()) {
            System.out.println("Invalid input. Please try again.");
            System.out.print("New creator: ");
            creator = sc.nextLine().trim();
        }

        this.value =value;
        this.creator =creator;
        return true;

    }
}
