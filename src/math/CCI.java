package math;

public class CCI {

    public static void main(String[] args) {
        System.out.println(findPrime(15));
    }
    static boolean findPrime(int n) {
        if (n < 2) {
            return false;
        }
        double sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
