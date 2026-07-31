package encapsulation_and_inheritance;

import java.util.Scanner;

public class Vase extends Item {


    private int height;//height of a vase (>=0 and <=2000)
    private String material;//material of a vase (is not empty)

    // TODO: you add more your codes
    //constructors
    //getter
    //setter
    public Vase() {
    }


    //this method is used to input all fields of a Vase object
    public void input() {
        //use Scanner class to input fields
        System.out.println("Input information vase:  ");
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


        int height;

        while (true) {
            System.out.print("Height: ");

            try {
                height = Integer.parseInt(sc.nextLine().trim());

                if (height >= 0 && height <= 2000) {
                    break;
                }

                System.out.println("Height must be greater than or equal to 0 and less than or equal to 2000.");
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }

        System.out.print("Material: ");
        String material;
        material = sc.nextLine().trim();
        while (material.isEmpty()) {
            System.out.println("Invalid input. Please try again.");
            System.out.print("Material: ");
            material = sc.nextLine().trim();
        }

        this.id = id;
        this.value = value;
        this.creator = creator;
        this.height = height;
        this.material = material;


    }

    //this method returns a string that includes value, creator, height ,material of a vase object
    public String toString() {
        return String.format("Value: %d, Creator: %s, Height: %d, Material: %s", value, creator, height, material);
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

                System.out.println("Value must be greater than or equal to 0 .");
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

        int height;

        while (true) {
            System.out.print("New height: ");

            try {
                height = Integer.parseInt(sc.nextLine().trim());

                if (height >= 0 && height <= 2000) {
                    break;
                }

                System.out.println("Height must be greater than or equal to 0 and less than or equal to 2000.");
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }

        System.out.print("New material: ");
        String material;
        material = sc.nextLine().trim();
        while (material.isEmpty()) {
            System.out.println("Invalid input. Please try again.");
            System.out.print("New material: ");
            material = sc.nextLine().trim();
        }

        this.value =value;
        this.creator =creator;
        this.height = height;
        this.material = material;
        return true;
    }
}
