package VariablesandDataTypes.src;
import java.util.Scanner;

public class EX1 {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        //Viet chuong trinh tinh chu vi, dien tich hinh tron nhap vao ban kinh
        //Nhap ban kinh
        System.out.print("Nhap vao ban kinh hinh tron: ");
        int r = new Scanner(System.in).nextInt();

        //Chu vi hinh tron.
        System.out.printf("Chu vi hinh tron. %.2f%n",Math.PI*r*2);
        //Dien tich hinh tron
        System.out.printf("Chu vi hinh tron. %.2f%n",Math.PI*Math.pow(r,2)  );
    }
}