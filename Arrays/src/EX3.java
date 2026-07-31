package Arrays.src;
import java.util.Scanner;

public class EX3 {
    public static void main(String[] args) {
        /*Indicates how many times element x appears in the array, with
        x entered by the user*/
        // Nhap mang
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap so phan tu cua mang");
        int n = sc.nextInt();
        int [] arrInt = new int[n];
        for (int i = 0; i<n; i++){
            System.out.print("nhap arrInt["+i+"]: " );
            arrInt[i] = sc.nextInt();


        }
        System.out.println("nhap so can tim so lan xuat  hien:");
        int numNeedFind = sc.nextInt();
        int count = 0;
        for (int num:arrInt){
            if(num==numNeedFind)
                count++;
        }
        System.out.println("so "+numNeedFind+" xuat hien "+ count);




    }
}
