package Loop.src;
import java.util.Scanner;

public class EX4 {
    public static void main(String[] args) {
        System.out.println("Nhap so n: ");
        int n = new Scanner(System.in).nextInt();
        for(int i=1;i<=n;i++){
            for(int j = 1;j<=i;j++)
                System.out.print(j);
            System.out.println();
        }
        System.out.println("------");
        for(int i=n;i>=1;i--){
            for(int j = 1;j<=i;j++)
                System.out.print(j);
            System.out.println();
        }
    }
}
