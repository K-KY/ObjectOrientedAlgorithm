package org.example.boj;

import java.util.Arrays;
import java.util.Scanner;

/*문제
도현이의 집 N개가 수직선 위에 있다. 각각의 집의 좌표는 x1, ..., xN이고, 집 여러개가 같은 좌표를 가지는 일은 없다.

도현이는 언제 어디서나 와이파이를 즐기기 위해서 집에 공유기 C개를 설치하려고 한다.
최대한 많은 곳에서 와이파이를 사용하려고 하기 때문에, 한 집에는 공유기를 하나만 설치할 수 있고,
가장 인접한 두 공유기 사이의 거리를 가능한 크게 하여 설치하려고 한다.

C개의 공유기를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램을 작성하시오.

입력
첫째 줄에 집의 개수 N (2 ≤ N ≤ 200,000)과 공유기의 개수 C (2 ≤ C ≤ N)이 하나 이상의 빈 칸을 사이에 두고 주어진다.
둘째 줄부터 N개의 줄에는 집의 좌표를 나타내는 xi (0 ≤ xi ≤ 1,000,000,000)가 한 줄에 하나씩 주어진다.

출력
첫째 줄에 가장 인접한 두 공유기 사이의 최대 거리를 출력한다.

설치 간격을 집의 최대 값부터 시작
다 설치하지 못했으면 집의 간격을 줄임
다 설치 했으면 집의 간격을 늘림


*/
public class P2110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int target = sc.nextInt();
        int[] homes = new int[len];
        for (int i = 0; i < len; i++) {
            homes[i] = sc.nextInt();
        }
        Arrays.sort(homes);

        System.out.println(homes.length);

        int i = binarySearch(homes, target);
        System.out.println(i);

    }


//0번부터 length - a[0] 까지
    //a[n] - last 가 mid보다 크거나 같다면 설치
    //작다면 스킵

    public static int binarySearch(int[] homes, int target) {
        int low = 1;
        int high = homes[homes.length - 1] - homes[0];
        int ans = 0;
        while (low <= high) {
            int last = homes[0];
            int placed = 1;
            int mid = (low + high) / 2;

            //전부 순회 해보고 남은 공유기 수 확인
            for (int i = 0; i < homes.length; i++) {
                if (homes[i] - last >= mid) {
                    placed++;
                    last = homes[i];
                }
            }

            //설치된게 target보다 크거나 같으면 mid가 답
            //클 필요가 있는 이유는 위 반복문에서 target 과 같아진경우 탈출 조건을 안 넣어줬기 때문
            if (placed >= target) {
                ans = mid;
                low = mid + 1;//mid를 더 키워서 다시 탐색
            }

            //다 설치하지 못한 경우 mid를 줄여서 다시 탐색
            if (placed < target) {
                high = mid - 1;
            }
        }
        return ans;
    }
}
