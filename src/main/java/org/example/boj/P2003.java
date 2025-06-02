package org.example.boj;

import java.util.Scanner;

/*
N개의 수로 된 수열 A[1], A[2], …, A[N] 이 있다.
이 수열의 i번째 수부터 j번째 수까지의 합 A[i] + A[i+1] + … + A[j-1] + A[j]가 M이 되는 경우의 수를 구하는 프로그램을 작성하시오.

10 5
1 2 3 4 2 5 3 1 1 2
1 3 6 10 12 17 20 21 22 24

1 3 **6** 10 12 **17** 20 21 **22** 24
* */
public class P2003 {
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
                if ((sums[j] - sums[i]) == target) {
                    answer++;
                    break;
                }
            }
        }


        System.out.println("answer = " + answer);

        for (int sum : sums) {
            System.out.println(sum);
        }
    }
}
