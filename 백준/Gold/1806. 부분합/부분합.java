import java.util.Arrays;
import java.util.Scanner;

/*문제
10,000 이하의 자연수로 이루어진 길이 N짜리 수열이 주어진다.
이 수열에서 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N (10 ≤ N < 100,000)과 S (0 < S ≤ 100,000,000)가 주어진다.
둘째 줄에는 수열이 주어진다. 수열의 각 원소는 공백으로 구분되어져 있으며, 10,000이하의 자연수이다.

출력
첫째 줄에 구하고자 하는 최소의 길이를 출력한다. 만일 그러한 합을 만드는 것이 불가능하다면 0을 출력하면 된다.*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int target = sc.nextInt();
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];//누적 합

            while (sum >= target) {//target보다 sum이 크거나 같으면 시작 인덱스부터 차감
                min = Math.min(min, i - start + 1);
                sum -= arr[start];
                start++;
            }
        }

        if (min == Integer.MAX_VALUE) {
            min = 0;
        }

        System.out.println(min);

    }
}
