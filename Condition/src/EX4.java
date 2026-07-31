package Condition.src;
import java.util.Scanner;

public class EX4 {
    public static void main(String[] args) {
        // viet chuong trinh danh gia hoc sinh dựa trên điều kiện sau.
        /*If marks > 75 – grade A
        If 60 < marks < 75 – grade B
        If 45 < marks<60 – grade C
        If 35 < marks<45 - grade D
        If marks < 35 – grade E*/
        System.out.println("Nhap diem so hoc sinh: ");
        double mark = new Scanner(System.in).nextDouble();
        System.out.print("Xep loai hoc sinh: ");
        XepLoai(mark);
        System.out.println();

    }
    public static void XepLoai(double mark){
        if(mark>=75)
            System.out.print("Loai A");
        else if (mark>=60) {
            System.out.print("Loai B");
        }
        else if (mark>=45) {
            System.out.print("Loai C");
        }
        else if (mark>=35) {
            System.out.print("Loai D");
        }else System.out.print("Loai E");
    }
}
