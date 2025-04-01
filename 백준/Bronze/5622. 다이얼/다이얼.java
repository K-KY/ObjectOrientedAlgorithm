import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10};
        Scanner sc = new Scanner(System.in);
        int[] array = sc.nextLine().chars().toArray();
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += nums[array[i] - 'A'] ;
        }

        System.out.println(sum);
    }
}