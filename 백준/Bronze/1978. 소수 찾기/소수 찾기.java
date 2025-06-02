import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int len = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int in = sc.nextInt();
            if (isTrue(in)) {
                sum++;
            }
        }
        
        System.out.println(sum);
    }
    
    static boolean isTrue(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}