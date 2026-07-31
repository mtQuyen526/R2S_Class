package VariablesandDataTypes.src;
import java.util.Scanner;

public class EX6 {
    public static void main(String[] args) {
        //nhap vao do dai 3 canh.
        double a;
        double b;
        double c;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap do danh ba canh: ");
        System.out.print("canh 1:");
        a = sc.nextDouble();
        System.out.print("canh 2:");
        b = sc.nextDouble();
        System.out.print("canh 3:");
        c = sc.nextDouble();
        double s = (a + b + c) / 2;
        System.out.println("Nua chu vi: s = (" + a + "+" + b + "+" + c + ")/2 = " + s);
        double dienTich = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        //System.out.println("Dien tich = " + "sqrt(" + s + "*(" + s + "-" + a + ")*(" + s + "-" + b + ")*(" + s + "-" + c + ")= " + dienTich);
        System.out.println("Căn bậc 2(" + s + "*(" + s + "-" + a + ")*(" + s + "-" + b + ")*(" + s + "-" + c + ")) = " + dienTich);
    }
}
