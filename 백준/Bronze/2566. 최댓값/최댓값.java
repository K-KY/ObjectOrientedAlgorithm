package org.example.boj;

import java.util.Arrays;
import java.util.Scanner;

public class P2566 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 0;
        int x = 0;
        int y = 0;
        for (int i = 1; i <= 9; i++) {
            int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < arr.length; j++) {
                int c = arr[j];
                if (c >= max) {
                    max = c;
                    x = i;
                    y = j + 1;
                }
            }

        }

        System.out.println(max);
        System.out.println(x + " " + y);

    }
}
/*
*
*
*
3 23 85 34 17 74 25 52 65
10 7 39 42 88 52 14 72 63
87 42 18 78 53 45 18 84 53
34 28 64 85 12 16 75 36 55
21 77 45 35 28 75 90 76 1
25 87 65 15 28 11 37 28 74
65 27 75 41 7 89 78 64 39
47 47 70 45 23 65 3 41 100
87 13 82 38 31 12 90 29 99
*/