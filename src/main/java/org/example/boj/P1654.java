package org.example.boj;

import java.util.Arrays;
import java.util.Scanner;

public class P1654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int has = sc.nextInt();
        int need = sc.nextInt();

        int[] lines = new int[has];

        for (int i = 0; i < has; i++) {
            lines[i] = sc.nextInt();
        }
        Arrays.sort(lines);

        long i = binarySearch(lines, need);

        System.out.println(i);
    }

    public static long binarySearch(int[] nums, int target) {
        long low = 0;
        long high = Integer.MAX_VALUE;
        long ans = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            long cut = 0;
            System.out.println("P1654.binarySearch");

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= mid) {
                    cut += nums[i]/mid;
                }
            }

            if (cut < target) {
                high = mid - 1;
            }

            if (cut >= target) {
                ans = mid;
                low = mid + 1;
            }
            System.out.println("cut = " + cut);
        }
        return ans;
    }
}
