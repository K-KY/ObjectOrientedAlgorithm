import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int target = sc.nextInt();

        int[] sums = new int[len];
        int answer = 0;
        for (int i = 0; i < len; i++) {
            int in = sc.nextInt();
            if (i == 0) {
                sums[i] = in;
                continue;
            }
            sums[i] = sums[i - 1] + in;
        }

        for (int i = 0; i < sums.length; i++) {
            if (sums[i] == target) {
                answer++;
            }
            for (int j = i + 1; j < sums.length ; j++) {
                if (sums[j] - sums[i] == target) {
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }
}
