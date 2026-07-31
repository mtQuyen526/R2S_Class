package Loop.src;
import java.util.Scanner;

public class EX2 {
/*    Accept two numbers num1 and num2. Find the sum of all odd numbers
    between the two numbers entered.*/
public static void main(String[] args) {
    int num1 ;
    int num2 ;
    // lay so chan lơn hon gan no nhat cua so be hon
    Scanner sc = new Scanner(System.in);
    System.out.print("nhap so thu nhat: ");
    num1 = sc.nextInt();
    System.out.print("nhap so thu nhat: ");
    num2 = sc.nextInt();

    // xuat tong so so le giua 2 so
    System.out.println("tong so so le giu 2 hai so: "+num1+" va "+num2+" : "+TongSoLeOGuaHaiSo(num1,num2));
}
public static int TongSoLeOGuaHaiSo(int num1,int num2){
    int sum = 0;
    int soLeNN;
    int soLeLN;
    if(num1>num2){
        soLeNN = 2*(int)((num2+1)/2)+1;
        soLeLN = 2*(int)((num1+1)/2) -1 -2*(num1%2);

    }else if(num2>num1){
        soLeNN = 2*(int)((num1+1)/2)+1;
        soLeLN = 2*(int)((num2+1)/2) -1 -2*(num2%2);
        }
    else return 0;
    int soSoLeGiuaHaiSo = (int)((soLeLN - soLeNN+1)/2)+(soLeLN-soLeNN+1)%2;
    if(soSoLeGiuaHaiSo<0)
        return  0;
    else
        return (soLeLN+soLeNN)*soSoLeGiuaHaiSo/2;
    }
}
