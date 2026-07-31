package Arrays.src;
public class EX7 {
    /*Find and display all the prime numbers in the array.*/
    public static void main(String[] args) {
        int x =  9;
        System.out.println(kiemTraSoNguyenTo(x));
        //System.out.println(isPrime(x));

    }

    public static boolean kiemTraSoNguyenTo(int num){
        int check = 0;
        for (int temp =2; temp<=num/temp;temp++){
            check++;
            System.out.println(check);
            if(num%temp==0)
                return false;
        }
        return true;

    }
    // ap dung ly thuyet so nguyen to. Mọi số nguyên tố lớn hơn 3 đều có dạng: 6k - 1 hoặc 6k + 1
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;

        if (n % 2 == 0 || n % 3 == 0)
            return false;
        int check =1;
        for (int i = 5; (long) i * i <= n; i += 6) {
            check++;
            System.out.println(check);
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }

        return true;
    }
}
