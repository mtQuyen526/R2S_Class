package Arrays.src;
import java.util.Scanner;

public class EX8_ISBN {
    public static void main(String[] args) {
        //Nhap vao doan ma ISBN can kiem tra, kieu so nguyen
        System.out.println("A valid ISBN has 10 digits.");
        System.out.println("Enter ISBN:");
        String strISBN = new Scanner(System.in).nextLine();

        //check
        for (;!(strISBN.length()==10)||!checkNumber(strISBN);){
            System.out.println("A valid ISBN has 10 digits. \n"+
                    "Please enter a valid ISBN: ");
            strISBN = new Scanner(System.in).nextLine();
        }
        // cover String ISBN to int[] arrayISBN
        int[] arrISBN = new int[10];
        for (int i=0;i<10;i++){
            arrISBN[i] = (int)strISBN.charAt(i)-48;
        }
        System.out.println("check code ISBN: ");
        if(checkISBN(arrISBN))
            System.out.println("Valid");
        else
            System.out.println("Invalid");
    }
    public static boolean checkNumber(String str){
        for (int i = 0; i<str.length();i++){
            char c = str.charAt(i);
            if((int)c<48||(int)c>57)
                return false;
        }
        return true;
    }
    public static boolean checkISBN(int[] arrISBN){
        if(!(arrISBN.length==10))
            return false;
        int sum = 0;
        for(int i =0;i<9;i++ )
            sum += arrISBN[i]*(10-i);
        if((sum+arrISBN[9])%11==0)
            return true;
        else
            return false;

    }
}
