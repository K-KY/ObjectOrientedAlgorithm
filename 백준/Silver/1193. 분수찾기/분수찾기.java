import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 1;
        int target = sc.nextInt();
        while (target > n * (n - 1) / 2) {
            n++;
        }

        int x = n - (target -  (n - 1) * ((n - 1) - 1) / 2);
        int y = n - x;
        if (n % 2 == 0) {
            System.out.println(x + "/" + y);
        }

        if (n % 2 != 0) {
            System.out.println(y + "/" + x);
        }
    }
}