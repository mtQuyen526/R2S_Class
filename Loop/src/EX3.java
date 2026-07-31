package Loop.src;
import java.util.ArrayList;
import java.util.Scanner;

public class EX3 {
    public static void main(String[] args) {
        /*Write a program to generate the Fibonacci series.
        (1,1,2,3,5,8,13,………).*/
        ArrayList<Integer> Fibonacci = new ArrayList<>();
        //nhap so luong so Fibonacci mong muon
        System.out.print("Nhap so luong so fibonacci: ");
        int n = new Scanner(System.in).nextInt();
        Fibonacci.add(1);
        Fibonacci.add(1);
        for (int i=2;i<n;i++){
            /*int numFibonacci = Fibonacci.get(i-1)+Fibonacci.get(i-2);
            Fibonacci.add(numFibonacci);*/
            Fibonacci.add(Fibonacci.get(i-1)+Fibonacci.get(i-2));
        }
        System.out.println(Fibonacci.toString());
    }
}
