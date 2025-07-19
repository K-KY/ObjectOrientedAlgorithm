import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 99) {
            System.out.print(n);
            return;
        }
        int sum = 99;
        for (int i = 100; i <= n; i++) {
            if (check(i)) {
                sum++;
            };
        }
        System.out.println(sum);
    }
    public static boolean check(int n) {
        String[] str = String.valueOf(n).split("");
        int dif = 0;
        for (int i = 0; i < str.length - 1; i++) {
            if (i == 0) {
                dif = Integer.parseInt(str[i]) - Integer.parseInt(str[i + 1]);
                continue;
            }
            if (dif != Integer.parseInt(str[i]) - Integer.parseInt(str[i + 1])) {
                return false;
            }
        }

        return true;

    }
    public static int parse(String i) {
        return Integer.parseInt(i);
    }
}