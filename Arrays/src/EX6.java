package Arrays.src;
import java.util.Scanner;

public class EX6 {
    /*Check if all elements of the array are odd*/
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
        int check = 0;
        for (int num:arrInt){
            if(num%2==0){
                System.out.println("mang co so chan");
                check++;
                break;
            }
        }
        if(check==0)
            System.out.println("mang toan bo so le");
    }
}
