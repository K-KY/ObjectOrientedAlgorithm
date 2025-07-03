package org.example.boj;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
/*총 N개의 문자열로 이루어진 집합 S가 주어진다.

입력으로 주어지는 M개의 문자열 중에서 집합 S에 포함되어 있는 것이 총 몇 개인지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 문자열의 개수 N과 M (1 ≤ N ≤ 10,000, 1 ≤ M ≤ 10,000)이 주어진다.

다음 N개의 줄에는 집합 S에 포함되어 있는 문자열들이 주어진다.

다음 M개의 줄에는 검사해야 하는 문자열들이 주어진다.

입력으로 주어지는 문자열은 알파벳 소문자로만 이루어져 있으며, 길이는 500을 넘지 않는다. 집합 S에 같은 문자열이 여러 번 주어지는 경우는 없다.
5 11
baekjoononlinejudge
startlink
codeplus
sundaycoding
codingsh
baekjoon
codeplus
codeminus
startlink
starlink
sundaycoding
codingsh
codinghs
sondaycoding
startrink
icerink
compareTo
음수면 오른쪽
양수면 왼쪽으로
*/
public class P11425 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int ans = 0;
        System.out.println();
        String[] dict = new String[n];
        String[] targets = new String[m];

        for (int i = 0; i < n; i++) {
            dict[i] = in.next();
        }

        for (int i = 0; i < m; i++) {
            targets[i] = in.next();
        }

        if (dict.length < targets.length) {
            String[] temp = dict;
            dict = targets;
            targets = temp;
            m = n;
        }
        Arrays.sort(dict, String::compareTo);
        for (int i = 0; i < m; i++) {
            int s = binarySearch(dict, targets[i], 0, dict.length - 1);
            if (s == 0) {
                ans++;
                System.out.println("s = " + s);
            }
        }



//        for (String s : dict) {
//            System.out.println("s = " + s);
//        }
//
//        for (String s : targets) {
//            System.out.println("d = " + s);
//        }
    }

    public static int binarySearch(String[] dict, String target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (dict[mid].compareTo(target) > 0) {
                high = mid - 1;
            }

            if (dict[mid].compareTo(target) < 0) {
                low = mid + 1;
            }

            if (dict[mid].compareTo(target) == 0) {
                return 0;
            }
        }
        return -1;
    }
}
