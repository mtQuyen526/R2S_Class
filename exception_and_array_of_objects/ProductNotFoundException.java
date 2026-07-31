package exception_and_array_of_objects;

// Custom exception for handling cases where product ID is not found
public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
