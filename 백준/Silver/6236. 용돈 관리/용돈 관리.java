import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int target = sc.nextInt();

        int[] spend = new int[len];
        for (int i = 0; i < len; i++) {
            spend[i] = sc.nextInt();
        }


        int i = binarySearch(spend, target);
        System.out.println(i);
    }

    public static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length * 10000;

        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;

            boolean drawable = drawable(nums, mid, target);

            if (drawable) {
                ans=mid;
                high = mid - 1;
            }
            if (!drawable) {
                low = mid + 1;
            }

        }
        return ans;
    }

    public static boolean drawable(int[] nums, int draw, int target) {
        int asset = draw;
        int withdraw = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > draw) {
                return false;
            }
            if (asset < nums[i]) {
                if (withdraw == target) {
                    return false;
                }
                withdraw++;
                asset = draw;
            }
            asset -= nums[i];
        }

        return true;
    }
}