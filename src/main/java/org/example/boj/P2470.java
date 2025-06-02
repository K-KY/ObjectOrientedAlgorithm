package org.example.boj;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P2470 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        Arrays.sort(arr);

        for (int i : arr) {
            System.out.println(i);
        }

        for (int j = 0; j < arr.length; j++) {
            int bs = binarySearch(arr, arr[j], j + 1);
            System.out.println("bs = " + bs);
            if (Math.abs(arr[bs] + arr[j]) < min) {
                min = Math.abs(arr[bs] + arr[j]);
                left = arr[j];
                right = arr[bs];
            }
        }


        if (left > right) {
            System.out.print(right + " " + left);
            return;
        }

        if (left < right) {
            System.out.print(left + " " + right);
            return;
        }
        System.out.print(left + " " + right);

    }

    public static int binarySearch(int[] arr, int n, int low) {
        //arr[i] + n 이 Abs(min)보다 작으면 교체
        //arr[i] + n 이 0보다 작으면 low = mid + 1
        //arr[i] + n 이 0보다 크면 high = mid - 1
        int high = arr.length - 1;
        int index = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] + n == 0) {
                return mid;
            }

            if (arr[mid] + n < 0) {
                if (Math.abs(arr[index] + n) > Math.abs(arr[mid] + n)) {
                    index = mid;
                }
                low = mid + 1;

            }

            if (arr[mid] + n > 0) {
                if (Math.abs(arr[index] + n) > Math.abs(arr[mid] + n)) {
                    index = mid;
                }
                high = mid - 1;
            }
            System.out.println("mid = " + mid);
            System.out.println("n = " + n);
            System.out.println("arr[mid] = " + arr[mid]);
        }

        System.out.println("final index = " + index);
        return index;

    }
}

/*
5

-2 4 -99 -1 98

-99 98



5

-2 4 -99 -1 99

-99 99



5

-2 4 1 -1 99

-1 1



10

-87 -42 -40 -22 -11 23 29 78 79 98

-22 23



5

-6 -8 -1 -2 -3

-2 -1


################
5

6 8 1 2 3
################
1 2



3

-10 1 2

1 2



4

999999995 999999996 999999997 1000000000

999999995 999999996



5

-98 -97 1 2 92

1 2

*/