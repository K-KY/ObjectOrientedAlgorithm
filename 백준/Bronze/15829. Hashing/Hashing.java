import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();
        BigInteger ans = BigInteger.valueOf(0);
        BigInteger pow = BigInteger.valueOf(1);
        BigInteger mod = BigInteger.valueOf(1234567891);

        for (int i = 0; i < n; i++) {
            int c = (s.charAt(i) - 'a') + 1;
            ans = ans.add(pow.multiply(BigInteger.valueOf(c)));
            pow = pow.multiply(BigInteger.valueOf(31));
        }

        System.out.println(ans.mod(mod));
    }
}