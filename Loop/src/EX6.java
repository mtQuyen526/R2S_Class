package Loop.src;
import java.util.Scanner;

public class EX6 {
    public static void main(String[] args) {
        /*Write a program to print a multiplication table for a given number
                (number between 2 and 9)*/
        System.out.println("Nhap mot so tu 2-9: ");
        int n = new Scanner(System.in).nextInt();
        for(;n<2||n>9;){
            System.out.println("Nhap lai so tu 2-9: ");
            n= new Scanner(System.in).nextInt();
        }
        for (int i= 1; i<9;i++)
            System.out.println(n+"x"+i+"= "+(n*i));
    }
}
