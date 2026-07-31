package Condition.src;
import java.util.Scanner;

public class EX2 {
    public static void main(String[] args) {
        double a = new Scanner(System.in).nextDouble();
        double b = new Scanner(System.in).nextDouble();
        //System.out.println("a - b = "+a+" - "+b+"="+ (a-b));
        if(a-b==a||b-a==a){
            System.out.println("hien bang so thu nhat");
        } else if (a-b==b||b-a==b) {
            System.out.println("hieu bang so thu 2");

        }else System.out.println("hieu khong bang bat ki gia tri nao da nhap");
    }
}
