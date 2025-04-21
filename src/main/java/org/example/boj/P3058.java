package org.example.boj;


import java.util.Arrays;
import java.util.Scanner;

/*
*
*7개의 자연수가 주어질 때, 이들 중 짝수인 자연수들을 모두 골라 그 합을 구하고, 고른 짝수들 중 최솟값을 찾는 프로그램을 작성하시오.

예를 들어, 7개의 자연수 13, 78, 39, 42, 54, 93, 86가 주어지면 이들 중 짝수는 78, 42, 54, 86이므로
* 그 합은 78 + 42 + 54 + 86 = 260 이 되고, 42 < 54 < 78 < 86 이므로 짝수들 중 최솟값은 42가 된다.

* 입력된 숫자를 " " 로 분리
* 2 로 나눈 나머지가 0인 수를 더함
*
*/
public class P3058 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int min ;
        int sum;
        for (int i = 0; i < n; i++) {
            min = Integer.MAX_VALUE;
            sum = 0;
            int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] % 2 == 0) {
                    sum += arr[j];
                    min = Math.min(arr[j], min);
                }
            }
            System.out.println(sum + " " + min);
        }
    }
}
