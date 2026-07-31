package Arrays.src;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class EX1 {
    /*Write a C program to find the minimum and the maximum value in
    an array*/
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
        System.out.println("so lon nhat trong mang = "+ findMaxArray(arrInt));
        System.out.println("so nho nhat trong mang=  "+findMinArray(arrInt));
    }
    public static int findMaxArray(int[] arrInt)
    {
        int max = arrInt[0];
        for (int i = 1; i < arrInt.length;i++)
            if(arrInt[i]>max)
                max = arrInt[i];
        return max;
    }
    public static int findMinArray(int[] arrInt)
    {
        int min = arrInt[0];
        for (int i = 1; i < arrInt.length;i++)
            if(arrInt[i]<min)
                min = arrInt[i];
        return min;
    }
}