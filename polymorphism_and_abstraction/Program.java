package polymorphism_and_abstraction;

import java.util.Scanner;

public class Program {
    private Product[] products;
    private byte numOfProduct;
    private static final int MAX = 100;

    public Program() {
        products = new Product[MAX];
    }

    public void addProduct(Product product) {
        // Code here
        if (product == null) {
            System.out.println("Product cannot be null.");
            return;
        }
        for (int i = 0; i < MAX; i++)
            if (products[i] == null) {
                products[i] = product;
                numOfProduct++;
                System.out.println("Product added successfully.");
                return;
            }
        System.out.println("The product was added unsuccessfully. The list is full.");
    }

    public void displayProducts() {
        // Code here
        /*if (isEmpty()){
            System.out.println("Empty list.");
            return;
        }*/

        int check = 0;
        for (Product product : products) {
            if (product != null){
                System.out.println(product);
                check++;
            }
        }
        if(check == 0)
        {
            System.out.println("Empty list.");
        }
    }

    public Product findProduct(int id) {
        // Code here
        for (Product product : products)
            if (product.id == id)
                return product;
        return null;
    }
    public boolean isEmpty(){
        for (Product product: products)
            if (product != null)
                return false;
        return true;
    }

    public static void main(String[] args) {
        Program p = new Program();
        Scanner scanner = new Scanner(System.in);
        byte choice;

        do {
            System.out.println("1. Add Product");
            System.out.println("2. Display Products");
            System.out.println("3. Find Product");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = Byte.parseByte(scanner.nextLine());

            switch (choice) {
                case 1:
                    // Logic to add product
                    int choiceProduct;

                    while (true) {
                        System.out.println("""
                                There are two types of products:
                                1. Electronics
                                2. Clothing
                                Please select the type of product you wish to add.
                                """);
                        choiceProduct = Integer.parseInt(scanner.nextLine());
                        if (choiceProduct == 1 || choiceProduct == 2)
                            break;
                    }

                    Product product;
                    int idAdd;
                    String nameAdd;
                    double priceAdd;
                    System.out.print("id: ");
                    idAdd = Integer.parseInt(scanner.nextLine());
                    System.out.print("name: ");
                    nameAdd = scanner.nextLine().trim();
                    System.out.print("price: ");
                    priceAdd = Double.parseDouble(scanner.nextLine());
                    switch (choiceProduct) {
                        case 1: // Electronics
                            String brand;
                            System.out.print("brand: ");
                            brand = scanner.nextLine().trim();

                            product = new Electronics(idAdd, nameAdd, priceAdd, brand);
                            p.addProduct(product);
                            break;
                        case 2:  // Clothing
                            String size;
                            System.out.print("size: ");
                            size = scanner.nextLine().trim();

                            product = new Clothing(idAdd, nameAdd, priceAdd, size);
                            p.addProduct(product);
                    }
                    break;
                case 2:
                    // Logic to display products
                    p.displayProducts();
                    break;
                case 3:
                    // Logic to find product
                    int idFind;
                    System.out.print("Find id: ");
                    idFind  = Integer.parseInt(scanner.nextLine());
                    System.out.println(p.findProduct(idFind));
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        scanner.close();
    }


}
