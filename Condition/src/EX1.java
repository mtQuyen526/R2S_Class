package Condition.src;
import java.util.Scanner;


public class EX1 {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        // Viet chuong trinh nhap vao 2 so, cho biet tich 2 so có bằng hoặc lớn hơn 1000 không.
        Scanner sc = new Scanner(System.in);
        double a;
        double b;
        a = sc.nextDouble();
        b = sc.nextDouble();

        System.out.println("tich hai so lon hon 1000: "+CheckEqual(a,b));



    }
    public static boolean CheckEqual(double a,double b){
        if(a*b>=1000)
            return true;
        else return false;
    }
}