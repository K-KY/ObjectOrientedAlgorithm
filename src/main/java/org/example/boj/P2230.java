package org.example.boj;


import java.util.Arrays;
import java.util.Scanner;

/*N개의 정수로 이루어진 수열 A[1], A[2], …, A[N]이 있다. 이 수열에서 두 수를 골랐을 때(같은 수일 수도 있다),
 그 차이가 M 이상이면서 제일 작은 경우를 구하는 프로그램을 작성하시오.

예를 들어 수열이 {1, 2, 3, 4, 5}라고 하자.
만약 M = 3일 경우, 1 4, 1 5, 2 5를 골랐을 때 그 차이가 M 이상이 된다. 이 중에서 차이가 가장 작은 경우는 1 4나 2 5를 골랐을 때의 3이 된다.

입력
첫째 줄에 두 정수 N, M이 주어진다. 다음 N개의 줄에는 차례로 A[1], A[2], …, A[N]이 주어진다.

출력
첫째 줄에 M 이상이면서 가장 작은 차이를 출력한다. 항상 차이가 M이상인 두 수를 고를 수 있다.

*/
public class P2230 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int answer = Integer.MAX_VALUE;

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            int b = binarySearch(arr, target, arr[i]);
            if (b >= target) {
                answer = Math.min(answer, b);
            }

        }

        System.out.println(answer);
    }

    static int binarySearch(int[] arr, int target, int pivot) {
        int low = 0;
        int high = arr.length - 1;
        int r = 0;
        while (low <= high) {
            int mid = (low + high) / 2;

            System.out.println("mid = " + mid);
            System.out.println("arr[mid] = " + arr[mid]);
            System.out.println("pivot = " + pivot);
            if (pivot - arr[mid] >= target) {
                System.out.println("P2230.binarySearch");
                r = pivot - arr[mid];
                low = mid + 1;
            }

            if (pivot - arr[mid] < target) {
                high = mid - 1;
            }
        }
        System.out.println("r = " + r);
        return r;
    }
}
