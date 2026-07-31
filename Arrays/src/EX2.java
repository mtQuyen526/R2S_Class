package Arrays.src;
import java.util.Scanner;

public class EX2 {
    /*Write a program to calculate the sum of odd-valued elements
    in an array*/
    public static void main(String[] args) {
        System.out.println("Nhap vao n:");
        int n = new Scanner(System.in).nextInt();

        int[] arrInt = new int[n];
        System.out.println("Nhap vao mang:");
        for (int i=0;i<arrInt.length;i++)
        {
            System.out.print("arrInt["+i+"]=");
            arrInt[i] = new Scanner(System.in).nextInt();
        }

        //tong so le trong mang
        System.out.print("tong so le trong mang la: ");
        int tongSole = 0;
        for (int i = 0; i<arrInt.length;i++)
        {
            if(arrInt[i]%2 ==1)
                tongSole+=arrInt[i];
        }
        System.out.println(tongSole);
    }
}
