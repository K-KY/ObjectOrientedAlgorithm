import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] xor = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            xor[i] = xor[i - 1] ^ sc.nextInt();
        }

        int result = 0;
        for (int i = 0; i < q; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int xo = xor[s - 1] ^ xor[e];
            result ^= xo;
        }

        System.out.println(result);
    }
}
