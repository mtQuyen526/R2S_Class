package VariablesandDataTypes.src;
import java.util.Scanner;

public class EX2 {
    public static void main(String[] args) {
        //Viết chương trình nhập mức lương và tuổi từ người dung, rồi hiển thị.
        Scanner sc = new Scanner(System.in);
        //Nhap
        System.out.print("Nhap luong:");
        Double luong;
        luong = sc.nextDouble();
        System.out.print("Nhap tuoi: ");
        int tuoi;
        tuoi = sc.nextInt();
        //xuat
        System.out.println("Luong vua nhap: "+ luong+" tuoi: "+tuoi);
    }
}
