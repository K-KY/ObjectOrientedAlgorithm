import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] lenAndTarget = Stream.of(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] trees = Stream.of(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(trees);
        //0부터 max까지 탐색
        int i = binarySearch(trees, lenAndTarget[1]);
        System.out.println(i);

    }

    public static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums[nums.length - 1];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long sum = sum(nums, mid);
            if (sum == target) {
                return mid;
            }

            if (sum > target) {
                low = mid + 1;
            }

            if (sum < target) {
                high = mid - 1;
            }
        }
        return high;
    }

    public static long sum(int[] arr, int mid) {
        long sum = 0;
        for (long j : arr) {
            if (j > mid) {
                sum += j - mid;
            }
        }

        return sum;
    }
}
