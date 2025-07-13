import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int nf = fact(n);
        int kf = fact(k) * fact(n - k);
        System.out.println((int)(nf/kf));
    }
    
    public static int fact(int num) {
        if (num == 0) {
            return 1;
        }
        int f = 1;
        for (int i = 1; i <= num; i++) {
            f*=i;
        }
        return f;
    }
}