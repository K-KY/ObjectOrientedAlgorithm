import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int wallet = sc.nextInt();
        int[] coins = new int[len];
        int score = 0;
        for (int i = 0; i < len; i++) {
            coins[i] = sc.nextInt();
        }
        sc.close();
        for (int i = len - 1; 0 <= i; i--) {
            if (wallet % coins[i] != wallet) {
                int change = wallet / coins[i];
                score += change;
                wallet = wallet - coins[i] * change;
            }
        }

        System.out.println(score);

    }
}
