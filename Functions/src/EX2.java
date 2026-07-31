package Functions.src;
public class EX2 {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        int n =0;
        System.out.println(+n+"! ="+TinhGiaiThua(n));

    }
    public static int TinhGiaiThua(int num){
        int giaiThua =1;
        for(int i =1;i<=num;i++){
            giaiThua*=i;
        }
        return giaiThua;

    }
}