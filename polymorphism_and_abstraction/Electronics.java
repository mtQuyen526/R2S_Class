package polymorphism_and_abstraction;

public class Electronics extends Product {
    private String brand;

    public Electronics(int id, String name, double price, String brand) {
        super(id, name, price);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Electronics{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                "brand='" + brand + '\'' +
                '}';
    }
}

