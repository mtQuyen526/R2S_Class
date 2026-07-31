package exception_and_array_of_objects;

public class Product {
    private int productID;
    private String name;
    private double price;
    private int quantityInStock;
    // Constructor


    public Product() {
    }

    public Product(int productID, String name, double price, int quantityInStock) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    // getter

    public int getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    // setter

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void displayProductInfo() {
        System.out.println("Information product: ");
        System.out.println("id: " + productID +
                "\n name: " + name +
                "\n price: " + price +
                "\n quantityInStock: " + quantityInStock);
    }

    @Override
    public String toString() {
        return "Information product: " +
                "\n id: " + productID +
                "\n name: " + name +
                "\n price: " + price +
                "\n quantityInStock: " + quantityInStock;
    }
}
