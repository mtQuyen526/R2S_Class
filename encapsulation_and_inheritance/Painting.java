package encapsulation_and_inheritance;

import java.util.Scanner;

public class Painting extends Item {
    private int height; //the height of a painting object (height>=0 and <=2000)
    private int width; //the width of a painting object (height>=0 and <=3000)
    private boolean isWaterColor; //the painting object use s a watercolor or not
    private boolean isFramed; //the painting object has s a frame or not

    //You add more your code
    //constructors
    //getter
    //setter


    public Painting() {
    }

    //this method is used to input all fields of a painting object
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

        // ----

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

        int width;

        while (true) {
            System.out.print("Width: ");

            try {
                width = Integer.parseInt(sc.nextLine().trim());

                if (width >= 0 && width <= 3000) {
                    break;
                }

                System.out.println("Width must be greater than or equal to 0 and less than or equal to 3000.");
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }

        boolean isWaterColor;
        while (true) {
            System.out.print("Water Color (true or false): ");

            if (sc.hasNextBoolean()) {
                isWaterColor = sc.nextBoolean();
                sc.nextLine();
                break;
            } else {
                System.out.println("Invalid input. Please enter true or false.");
                sc.nextLine();
            }
        }

        boolean isFamed;
        while (true) {
            System.out.print("isFamed (true or false): ");

            if (sc.hasNextBoolean()) {
                isFamed = sc.nextBoolean();
                sc.nextLine();
                break;
            } else {
                System.out.println("Invalid input. Please enter true or false.");
                sc.nextLine();
            }
        }


        this.id = id;
        this.value = value;
        this.creator = creator;
        this.height = height;
        this.width = width;
        this.isWaterColor = isWaterColor;
        this.isFramed = isFamed;
    }

    //this method returns a string that includes all fields of a painting object
    public String toString() {
        return String.format("Value: %d, Creator: %s, Height: %d, Width: %d, isWaterColor: %b, isFramed: %b",
                value, creator, height, width, isWaterColor, isFramed);
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

        // ----

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

        int width;

        while (true) {
            System.out.print("New width: ");

            try {
                width = Integer.parseInt(sc.nextLine().trim());

                if (width >= 0 && width <= 3000) {
                    break;
                }

                System.out.println("Width must be greater than or equal to 0 and less than or equal to 3000.");
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }

        boolean isWaterColor;
        while (true) {
            System.out.print("New isWaterColor (true or false): ");

            if (sc.hasNextBoolean()) {
                isWaterColor = sc.nextBoolean();
                sc.nextLine();
                break;
            } else {
                System.out.println("Invalid input. Please enter true or false.");
                sc.nextLine();
            }
        }

        boolean isFamed;
        while (true) {
            System.out.print("New isFamed (true or false): ");

            if (sc.hasNextBoolean()) {
                isFamed = sc.nextBoolean();
                sc.nextLine();
                break;
            } else {
                System.out.println("Invalid input. Please enter true or false.");
                sc.nextLine();
            }
        }


        this.value = value;
        this.creator = creator;
        this.height = height;
        this.width = width;
        this.isWaterColor = isWaterColor;
        this.isFramed = isFamed;
        return true;
    }
}
