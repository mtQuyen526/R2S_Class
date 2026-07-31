package VariablesandDataTypes.src;
public class Diem {
    //thuoc tinh
    private double x;
    private double y;
    //Constructor

    public Diem() {
    }

    public Diem(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "( " + x + "," + y + " )";
    }
}
