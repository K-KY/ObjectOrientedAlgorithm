package org.example.boj;

import java.io.*;
import java.util.Arrays;

/*
n개의 서로 다른 양의 정수 a1, a2, ..., an으로 이루어진 수열이 있다.
 ai의 값은 1보다 크거나 같고, 1000000보다 작거나 같은 자연수이다.
 자연수 x가 주어졌을 때, ai + aj = x (1 ≤ i < j ≤ n)을 만족하는 (ai, aj)쌍의 수를 구하는 프로그램을 작성하시오.


9
5 12 7 10 9 1 2 3 11
13

정렬하고
0 번째 부터 n 번째 더함
타겟 크기보다 작으면 0 + 1 -> 오름차 순으로 정렬 되어있으니 0번 째 수와 어떤 수를 더하든 타겟 크기보다 작음
타겟 크기보다 크면 n - 1 0 -> 마찬가지로 타겟 크기보다 크면 n번 째 수와 어떤 수를 더하든 타겟 크기보다 큼
타겟 크기와 같으면 0 + 1, n - 1


 */
public class P3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int target = Integer.parseInt(br.readLine());
        int start = 0;
        int end = arr.length - 1;
        int ans = 0;
        while (start < end) {
            int plus = arr[start] + arr[end];
            if (plus == target) {
                end--;
                start++;
                ans++;
            }

            if (plus < target) {
                start++;
            }

            if (plus > target) {
                end--;
            }
        }
        System.out.println(ans);
    }
}
