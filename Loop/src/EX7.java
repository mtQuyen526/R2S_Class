package Loop.src;
import java.util.Scanner;

public class EX7 {
    public static void main(String[] args) {
        /*Write a program to check if the user-entered password is valid or not?
                Knowing that the valid password is 12345. Each time the user enters incorrectly, the
        program will display 'Invalid password' and allow the user to re-enter. The program
        will end if the user enters the correct password or exceeds 3 incorrect attempts*/
        final String PASSWORD = "12345";
        System.out.println("Nhap password: ");
        String passWord = new Scanner(System.in).nextLine();
        for (int i =0;i<2;i++){
            if (!passWord.equals(PASSWORD)) {
                System.out.println("Invalid password");
                System.out.println("Please enter the password again:");
                passWord = new Scanner(System.in).nextLine();
            }
            else{
                System.out.println("Password is correct");
                break;
            }
            if(i==1){
                System.out.println("Too many failed attempts");
            }
        }
    }
}
