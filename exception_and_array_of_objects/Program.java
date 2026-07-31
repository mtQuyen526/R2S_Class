package exception_and_array_of_objects;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        ProductManagement pm = new ProductManagement();
        Scanner sc = new Scanner(System.in);

        // Adding products
        try {
            pm.addProduct(new Product(101, "Laptop", 999.99, 10));
            pm.addProduct(new Product(102, "Smartphone", 799.99, 20));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Retrieving a product
        try {
            Product product = pm.getProductByID(101);
            product.displayProductInfo();
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Updating product quantity
        try {
            pm.updateProductQuantity(102, 15);
        } catch (ProductNotFoundException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // -----------------MENU-----------------

        String choice;
        do {
            System.out.println("""
                    1. Add Product.
                    2. Retrieve Product by ID.
                    3. Update Product Quantity.
                    4. Exist.
                    """);

            System.out.print("Select an option: ");
            choice = sc.nextLine().trim();
            int productID;
            String name;
            double price;
            int quantityInStock;
            switch (choice) {
                case "1":
                    System.out.println("Enter product detail: ");
                    while (true) {
                        try {
                            System.out.print("Product ID: ");
                            productID = Integer.parseInt(sc.nextLine());
                            System.out.print("Product Name: ");
                            name = sc.nextLine();
                            System.out.print("Product Price: ");
                            price = Double.parseDouble(sc.nextLine());
                            System.out.print("Quantity in Stock: ");
                            quantityInStock = Integer.parseInt(sc.nextLine());
                        } catch (Exception ex) {
                            System.out.println("Please Re-enter.");
                            ex.printStackTrace();
                            continue;
                        }
                        break;
                    }
                    try {
                        pm.addProduct(new Product(productID, name, price, quantityInStock));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "2":
                    while (true) {
                        try {
                            System.out.print("Enter Product ID to retrieve: ");
                            productID = Integer.parseInt(sc.nextLine());
                        } catch (Exception ex) {
                            System.out.println("Please Re-enter.");
                            ex.printStackTrace();
                            continue;
                        }
                        break;
                    }
                    try {
                        System.out.println(pm.getProductByID(productID));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "3":
                    while (true) {
                        try {
                            System.out.print("Enter Product ID to update: ");
                            productID = Integer.parseInt(sc.nextLine());
                        } catch (Exception ex) {
                            System.out.println("Please Re-enter.");
                            ex.printStackTrace();
                            continue;
                        }
                        break;
                    }
                    while (true) {
                        try {
                            System.out.print("Enter new quantity: ");
                            quantityInStock = Integer.parseInt(sc.nextLine());
                        } catch (Exception ex) {
                            System.out.println("Please Re-enter.");
                            ex.printStackTrace();
                            continue;
                        }
                        break;
                    }
                    try {
                        pm.updateProductQuantity(productID, quantityInStock);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "4":
                    System.out.println("Exiting the program...");
                    break;
            }
        }while (!choice.equalsIgnoreCase("4"));
    }
}
