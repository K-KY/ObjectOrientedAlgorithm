import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int loop = in.nextInt();
        for (int i = 0; i < loop; i++) {
            int h = in.nextInt();
            int w = in.nextInt();
            int n = in.nextInt();
            int f = 0;
            int r = 1;

            while (n - h > 0) {
                n -= h;
                r++;
            }
            f = n;


            if (r < 10) {
                System.out.println(f + "0" + r);
            }
            if (r >= 10) {
                System.out.println(f + "" + r);
            }

        }
    }
}
