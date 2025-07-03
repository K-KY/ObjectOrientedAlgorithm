package org.example.boj;

import java.util.Arrays;
import java.util.Scanner;
/*
*
3
-5 -2 -1
*
5
-100,1,2,3,4


*
* */
public class P2970 {
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
            int bs = binarySearch(arr, arr[j], j + 1, len - 1);
            System.out.println("bs = " + bs);
            if (Math.abs(arr[bs] + arr[j]) < min) {
                System.out.println("min = " + min);
                System.out.println("Math.abs(arr[bs] + arr[j]) = " + Math.abs(arr[bs] + arr[j]));
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

    public static int binarySearch(int[] arr, int n, int low, int len) {
        //arr[i] + n 이 Abs(min)보다 작으면 교체
        //arr[i] + n 이 0보다 작으면 low = mid + 1
        //arr[i] + n 이 0보다 크면 high = mid - 1
        int high = arr.length - 1;
        int min = Integer.MAX_VALUE;
        int index = 0;

        int l = low;
        int r = len;

        while (l <= r) {
            int mid = (l + r) / 2;
            int sum = n + arr[mid];

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                index = mid;
            }
            if (sum < 0) {
                l = mid + 1;
            }

            if (sum > 0) {
                r = mid - 1;
            }

            if (sum == 0) {
                return mid;
            }
        }
//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//
//            System.out.println("mid = " + mid);
//            System.out.println("n = " + n);
//            if (arr[mid] + n == 0) {
//                return mid;
//            }
//
//            if (arr[mid] + n < 0 && arr[mid] != n) {
//                if (Math.abs(min) > Math.abs(arr[mid] + n)) {
//                    min = Math.abs(arr[mid] + n);
//                    index = mid;
//                }
//                low = mid + 1;
//
//            }
//
//            if (arr[mid] + n > 0 && arr[mid] != n) {
//                if (Math.abs(min) > Math.abs(arr[mid] + n)) {
//                    min = Math.abs(arr[mid] + n);
//                    index = mid;
//                }
//
//                high = mid - 1;
//            }
//
//
//
//        }


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



5

6 8 1 2 3

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