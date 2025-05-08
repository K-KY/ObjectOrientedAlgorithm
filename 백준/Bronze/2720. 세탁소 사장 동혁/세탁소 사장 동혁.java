import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] coin = {25, 10, 5, 1};
        int r = sc.nextInt();
        for (int i = 0; i < r; i++) {
            int v = sc.nextInt();
            StringJoiner sj = new StringJoiner(" ");

            for (int j = 0; j < coin.length; j++) {
                sj.add(v / coin[j] + "");
                v %= coin[j];
            }
            System.out.println(sj);
        }
    }
}