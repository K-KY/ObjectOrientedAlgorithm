import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        StringBuilder sb;
        String str = "";
        for (int i = 1; i <= n; i++) {
            sb = new StringBuilder();
            for (int j = 1; j <= n * 2 - i; j++) {
                if (j < i || j > n * 2 - i) {
                    sb.append(" ");
                    continue;
                }

                sb.append("*");

            }
            System.out.println(sb);
            if (i < n) {
                if( i > 1) {
                    sb.append("\n");
                }
                sb.append(str);
                str = sb.toString();
            }

        }
        System.out.println(str);
    }
}
