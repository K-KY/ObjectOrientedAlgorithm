import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int i = 1;
        while (true) {
            int splitSum = splitSum(i);
            if (splitSum == n) {
                System.out.println(i);
                return;
            }
            if (splitSum > n * 2) {
                System.out.println(0);
                return;
            }
            i++;
        }
    }

    public static int splitSum(int num) {
        int sum = 0;
        sum +=num;

        String[] numbers = String.valueOf(num).split("");

        for (int i = 0; i < numbers.length; i++) {
            sum += Integer.parseInt(numbers[i]);
        }
        return sum;
    }
}