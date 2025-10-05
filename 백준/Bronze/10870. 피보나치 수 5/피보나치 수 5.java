import java.util.*;
public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int crt = 0;//0, 1, 1, 2
            int prev = 0;
            for (int i = 0; i < n; i++) {
                if (crt + prev == 0) {
                    crt = 1;
                    prev = 0;
                    continue;
                }

                crt = crt + prev;// 1 + 0 = 1, 1 + 1 = 2
                prev = crt - prev;//0, 1, 2
            }

            System.out.println(crt);
        }
}