package org.example.boj;


import java.util.*;
import java.util.stream.Collectors;

/*
* 문제
N(5 ≤ N ≤ 1,000)개의 자연수들로 이루어진 집합 U가 있다.
* 이 중에서 적당히 세 수를 골랐을 때, 그 세 수의 합 d도 U안에 포함되는 경우가 있을 수 있다. 이러한 경우들 중에서, 가장 큰 d를 찾으라.

예를 들어 {2, 3, 5, 10, 18}와 같은 집합이 있다고 하자.
* 2+3+5 = 10이 되고, 이 수는 집합에 포함된다. 하지만 3+5+10 = 18이 되고, 이 경우가 세 수의 합이 가장 커지는 경우이다.

입력
첫째 줄에 자연수 N이 주어진다. 다음 N개의 줄에 차례로 U의 원소가 하나씩 주어진다.
* 주어진 U는 집합이 되므로 입력되는 두 수가 같아서는 안 된다. U의 원소는 200,000,000보다 작거나 같은 자연수이다.
* 답이 항상 존재하는 경우만 입력으로 주어진다.

출력
우리가 x번째 수, y번째 수, z번째 수를 더해서 k번째 수를 만들었다라고 하자.
위의 예제에서 2+3+5=10의 경우는 x, y, z, k가 차례로 1, 2, 3, 4가 되며, 최적해의 경우는 2, 3, 4, 5가 된다.
k번째 수가 최대가 되도록 하는 것이 목적이다. x, y, z, k가 서로 같아도 된다. 이때, k번째 수를 출력하면 된다.


* 3중반복
* 더한 값 이진탐색
* 찾으면 max


*/
public class P2295 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Set<Integer> prefixSum = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                prefixSum.add(arr[i] + arr[j]);
            }
        }
        List<Integer> prefixList = new ArrayList<>(prefixSum);
        prefixList.sort(Integer::compareTo);

        System.out.println("prefixList = " + prefixList);
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int remain = arr[i] - arr[j];//10 - 2
                if (binarySearch(prefixList, remain) != -1) {
                    answer = Math.max(arr[i], answer);
                }
            }
        }

        System.out.println(answer);
    }

    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return arr[mid];
            }

            if (arr[mid] > target) {
                high = mid - 1;
            }
            if (arr[mid] < target) {
                low = mid + 1;
            }
        }
        return -1;
    }
    public static int binarySearch(List<Integer> arr, int target) {
        int low = 0;
        int high = arr.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) == target) {
                return arr.get(mid);
            }

            if (arr.get(mid) > target) {
                high = mid - 1;
            }
            if (arr.get(mid) < target) {
                low = mid + 1;
            }
        }
        return -1;
    }
}
