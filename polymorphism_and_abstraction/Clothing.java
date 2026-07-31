package polymorphism_and_abstraction;

public class Clothing extends Product {
    private String size;


    public Clothing(int id, String name, double price, String size) {
        super(id, name, price);
        this.size = size;
    }

    @Override
    public String toString() {
        return "Clothing{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                "size='" + size + '\'' +
                '}';
    }
}
