package VariablesandDataTypes.src;
import java.util.Scanner;

public class EX4 {
    public static void main(String[] args) {
        int num;
        int digit1;
        int digit2;
        int digit3;
        //Nhap vao 1 so co 3 chu so.
        System.out.print("Nhap vao mot so co 3 chu so XXX: ");
        num = new Scanner(System.in).nextInt();
        int tongNumber = 0;
        int check = num;
        digit1 = check % 10;
        check /= 10;
        tongNumber += digit1;

        digit2 = check % 10;
        check /= 10;
        tongNumber += digit2;

        digit3 = check % 10;
        check /= 10;
        tongNumber += digit3;

        /*for (int check = num; check > 0; ) {
            tongNumber += check % 10;
            check = check / 10;
        }*/
        System.out.println("Digit1: " + digit1);
        System.out.println("Digit2: " + digit2);
        System.out.println("Digit3: " + digit3);
        System.out.println("Tong cac chu so cua so: " + num + " la: " + tongNumber);
    }
}
