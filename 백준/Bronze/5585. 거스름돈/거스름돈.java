import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] coins = {500, 100, 50, 10, 5, 1};
        Scanner sc = new Scanner(System.in);
        int target = 1000 - sc.nextInt();
        int scope = 0;
        int used = 0;
        while (target != 0) {
            if (target - coins[scope] >= 0) {
                target -= coins[scope];
                used++;
                continue;
            }
            scope++;
        }
        System.out.println(used);
    }
}