package org.example.boj;

import java.util.Scanner;

public class P2908 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String[] nums = sc.nextLine().split(" ");
        int a = reverse(nums[0], sb);
        int b = reverse(nums[1], sb);
        System.out.println(Math.max(a, b));
    }

    public static int reverse(String s, StringBuilder sb) {
        sb.setLength(0);
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i) + "");
        }
        return Integer.parseInt(sb.toString());
    }
}