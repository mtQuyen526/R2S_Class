package Arrays.src;
import java.util.Scanner;

public class EX5 {
    /*Indicates how many elements in the array have values less than 0*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap so phan tu cua mang");
        int n = sc.nextInt();
        for (;n<0;){
            System.out.println("nhap lai n: ");
            n = sc.nextInt();
        }
        int [] arrInt = new int[n];
        for (int i = 0; i<n; i++){
            System.out.print("nhap arrInt["+i+"]: " );
            arrInt[i] = sc.nextInt();
        }
        System.out.println("cac so nho hon 0");
        for (int num:arrInt){
            if(num<0){
                System.out.println(num);
            }
        }
    }
}
