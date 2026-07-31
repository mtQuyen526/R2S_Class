package encapsulation_and_inheritance;

import java.util.Scanner;

public class Statue extends Item {
    private int weight; //the weight of a statue object (weight>=0 and <=1000)
    private String color; //the color of a statue object (is not empty)

    //You add more your code
    // TODO: you add more your codes
    //constructors
    //getter
    //setter


    public Statue() {
    }

    //this method is used to input all fields of a statue object
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


        int weight;

        while (true) {
            System.out.print("Weight: ");

            try {
                weight = Integer.parseInt(sc.nextLine().trim());

                if (weight >= 0 && weight <= 1000) {
                    break;
                }

                System.out.println("Weight must be greater than or equal to 0 and less than or equal to 1000.");
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
        System.out.println("Color: ");
        String color;
        color = sc.nextLine().trim();
        while (color.isEmpty()) {
            System.out.println("Invalid input. Please try again.");
            System.out.print("Color: ");
            color = sc.nextLine().trim();
        }


        this.id = id;
        this.value = value;
        this.creator = creator;
        this.weight = weight;
        this.color = color;
    }

    //this method returns a string that includes value, creator, weight, color of a statue object
    public String toString() {
        return String.format("Value: %d, Creator: %s, Weight: %d, Color: %s", value, creator, weight, color);
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


        int weight;

        while (true) {
            System.out.print("New weight: ");

            try {
                weight = Integer.parseInt(sc.nextLine().trim());

                if (weight >= 0 && weight <= 1000) {
                    break;
                }

                System.out.println("Weight must be greater than or equal to 0 and less than or equal to 1000.");
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
        System.out.println("New color: ");
        String color;
        color = sc.nextLine().trim();
        while (color.isEmpty()) {
            System.out.println("Invalid input. Please try again.");
            System.out.print("New color: ");
            color = sc.nextLine().trim();
        }


        this.value = value;
        this.creator = creator;
        this.weight = weight;
        this.color = color;
        return true;
    }
}
