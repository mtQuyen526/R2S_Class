package Condition.src;
import java.util.Scanner;

public class EX5 {
    public static void main(String[] args) {
        System.out.println("Nhap mot ki tu: ");
        String c = new Scanner(System.in).nextLine();
        for (;c.length()>1;)
        {
            System.out.println("Vui long nhap mot ki tu:");
            c = new Scanner(System.in).nextLine();
        }
        if(c.equalsIgnoreCase("b"))
            System.out.println("Basic");
        else if (c.equalsIgnoreCase("c")) {
            System.out.println("Cobol");
        }else if (c.equalsIgnoreCase("f")) {
            System.out.println("Fortran");
        }else if (c.equalsIgnoreCase("p")) {
            System.out.println("Pascal");
        }else if (c.equalsIgnoreCase("v")) {
            System.out.println("Visual C++");
        }else System.out.println("undefined");


    }
}
