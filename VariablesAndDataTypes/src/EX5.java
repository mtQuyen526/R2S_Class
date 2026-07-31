package VariablesandDataTypes.src;
import java.util.Scanner;

public class EX5 {
    public static void main(String[] args) {
        Diem diem1;
        Diem diem2;
        double x;
        double y;
        Scanner sc = new Scanner(System.in);

        System.out.println("nhap vao toa do diem 1: ");
        System.out.print("x: ");
        x = sc.nextDouble();
        System.out.print("y: ");
        y = sc.nextDouble();
        diem1 = new Diem(x, y);

        System.out.println("nhap vao toa do diem 2: ");
        System.out.print("x: ");
        x = sc.nextDouble();
        System.out.print("y: ");
        y = sc.nextDouble();
        diem2 = new Diem(x, y);

        System.out.print("Khoan cach 2 diem: " + diem1.toString() + " và " + diem2.toString() + " là: " + KhoanCachHaiDiem(diem1, diem2));


    }

    public static double KhoanCachHaiDiem(Diem diem1, Diem diem2) {
        return Math.sqrt(Math.pow(diem2.getX() - diem1.getX(), 2) + Math.pow(diem2.getY() - diem1.getY(), 2));
    }
}
