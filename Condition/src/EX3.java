package Condition.src;
import java.util.Scanner;

public class EX3 {
    public static void main(String[] args) {
        double basicSallary = 120000;
        String capBac;
        System.out.println("Nhap vao cap bac nhan vien:");
        capBac = new Scanner(System.in).nextLine();
        NhanVien nv = new NhanVien(basicSallary,capBac);
        //System.out.println("cap bac nhan vien: "+nv.getCapBac());
        System.out.println("luong nv:"+TinhLuong(nv));

    }
    public static double TinhLuong(NhanVien nv){
       // if(nv.getCapBac().toString())
        if(nv.getCapBac().toString().equalsIgnoreCase("A")){
            return nv.getLuong()+300;
        }else if(nv.getCapBac().toString().equalsIgnoreCase("B")){
            return nv.getLuong()+200;
        }
            return nv.getLuong()+100;
        }
    }

