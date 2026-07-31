package Condition.src;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EX6 {
    public static void main(String[] args) {
        /*Chương trình giải phương trình bậc hai
        Viết chương trình giải phương trình bậc hai dạng ax^2 + bx + c = 0.
        Yêu cầu người dùng nhập các giá trị cho các hệ số a, b và c. Tính toán
        biệt thức (delta) bằng công thức delta = b^2 - 4ac. Nếu delta dương, tính
        và hiển thị các nghiệm của phương trình bằng công thức nghiệm bậc hai. Nếu delta bằng 0 hoặc
        âm, hiển thị một thông báo thích hợp.*/
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap hệ số a, b, c của phương trình bật 2: ax^2+bx+c=0 ");
        int a;
        int b;
        int c;
        System.out.print("a: ");
        a= sc.nextInt();
        System.out.print("b: ");
        b= sc.nextInt();
        System.out.print("c: ");
        c= sc.nextInt();
        System.out.println(TinhNghiem(a,b,c));

    }//main
    //ham tinh delta
    public static double Delta(double a,double b, double c){
        return Math.pow(b,2)-4*a*c;
    }
    //ham check nguyen
    public static boolean checkNguyen(double x)
    {
        return x - (int) x == 0;
    }

    //ham tim Danh sach uoc so
    //sử dụng HasMap, key là ước, value là mũ
    public static HashMap<Integer,Integer> TimUocSo(int x){
        HashMap<Integer,Integer> DsUocVaMu = new HashMap<>();
        int temp = x;

        while (temp>1){
            int unn = UNN(temp);
            //kiem tra uoc da ton tai chua
            if(!DsUocVaMu.containsKey(unn)){ // chua ton tai
                DsUocVaMu.put(unn,1);
            }else // da ton tai
            {

                DsUocVaMu.put(unn,DsUocVaMu.get(unn)+1);
            }
            temp/=unn;
        }
      return DsUocVaMu;
    }

    //ham tim uoc so nho nhat cua mot so.
    public static int UNN(int x) {
        for (int i = 2; i <= x / i; i++)
            if (x % i == 0)
                return i;
        return x;
    }
    // ham xuat can bat 2 rut gon.
    public static String RutGonCan2(int x){
        HashMap<Integer,Integer> DsUocVaMu = TimUocSo(x);// gồm (uơcSo,mũ)
       /* ArrayList<Integer> DsUoc = new ArrayList<>(); //gồm (ước)
        DsUoc.addAll(DsUocVaMu.keySet());*/
        ArrayList<Integer> DsUoc = new ArrayList<>(DsUocVaMu.keySet());
        int phanNguyen=1;
        int phanCan=1;
        for (Integer element:DsUoc){
            phanNguyen*= Math.pow(element,(int)(DsUocVaMu.get(element)/2));
            phanCan*= Math.pow(element,DsUocVaMu.get(element)%2);
        }
        if(phanCan==1)
            return phanNguyen+"";
        return phanNguyen+"sqrt("+phanCan+")";
    }
    //ham xuat nghiem.

//ham tim UCLN
    public static int UCLN(int a,int b){
        while (b!=0){
            int r = a%b;
            a=b;
            b=r;
        }
        return a;
    }


//ham xuat rut gon phan so.
    public static String RutGonPhanSo(int tu,int mau){
        if(checkNguyen((double) tu/mau)){
            return tu/mau+"";
        }else if (Math.abs(tu)<Math.abs(mau))
            return tu/(UCLN(tu,mau))+"/"+mau/(UCLN(tu,mau));
        else {
            int phanNguyen = tu / mau;
            tu = tu - phanNguyen * mau;
            return phanNguyen + "*(" + tu / (UCLN(tu, mau)) + "/" + mau / (UCLN(tu, mau)) + ")";
        }
    }
    public static String TinhNghiem(int a, int b, int c){
        //kiem tra co nghiẹm
        double delta = Delta(a,b,c);
        if(delta<0)
            return "Vo nghiem";
        else if (delta==0) {
            return "phuong trinh có nghiệm kép: "+RutGonPhanSo(-b,2*a);
        }else{
            boolean checkCanDeltaNguyen= checkNguyen(Math.sqrt(delta));
            if(checkCanDeltaNguyen){
                return "nghiem 1: "+ RutGonPhanSo((int) (-b+Math.sqrt(delta)),2*a)+
                        "\nnghiem 2: " +RutGonPhanSo((int)(-b-Math.sqrt(delta)),2*a);
            }else
                return "nghiem 1: ("+ -b +"+"+RutGonCan2((int)delta)+")/"+2*a +
                        "\nnghiem 2: ("+ -b +"-"+RutGonCan2((int)delta)+")/"+2*a;

        }

    }
}
