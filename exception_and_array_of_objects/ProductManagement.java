package exception_and_array_of_objects;

public class ProductManagement {
    private Product[] products = new Product[10];
    private int productCount = 0;

    // Add a new product
    public void addProduct(Product product) throws IllegalArgumentException {
        if (productCount > products.length) {
            throw new IllegalArgumentException("List full");
        }

        // kiem kiem tra id trong list product
        /*for (Product productTemp : products) {
            if (productTemp != null)
                if (productTemp.getProductID() == product.getProductID()) {
                    throw new IllegalArgumentException("Id already exists.");
                }
        }*/

        try {
            if (getProductByID(product.getProductID()) != null) {
                throw new IllegalArgumentException("Id already exists.");
            }
        } catch (Exception ex) {

        }

        if (product.getPrice() <= 0) {
            throw new IllegalArgumentException("Price must be positive.");
        }
        if (product.getQuantityInStock() <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }


        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                productCount++;
                return;
            }
        }
    }

    // Retrieve a product by ID
    public Product getProductByID(int productID) throws ProductNotFoundException {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null)
                if (products[i].getProductID() == productID)
                    return products[i];
        }
        throw new ProductNotFoundException("Product with ID " + productID + " not found.");

    }

    // Update product quantity
    public void updateProductQuantity(int productID, int newQuantity) throws
            ProductNotFoundException {
        if (getProductByID(productID) != null) {
            System.out.println("Update id: " + productID);
            getProductByID(productID).setQuantityInStock(newQuantity);
            System.out.println("Update successful.");
        } else
            System.out.println("Update failed. Please check the information.");
    }
}
