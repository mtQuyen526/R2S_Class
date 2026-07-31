package Arrays.src;
import java.util.Scanner;

public class EX4 {
    /*Displays elements whose values are divisible by 3 or 5*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap so phan tu cua mang");
        int n = sc.nextInt();
        int [] arrInt = new int[n];
        for (int i = 0; i<n; i++){
            System.out.print("nhap arrInt["+i+"]: " );
            arrInt[i] = sc.nextInt();
        }
        System.out.println("cac so chia het cho 3 hoac 5");
        for (int num:arrInt){
            if(num%3==0 || num%5==0){
                System.out.println(num);
            }
        }

    }
}
