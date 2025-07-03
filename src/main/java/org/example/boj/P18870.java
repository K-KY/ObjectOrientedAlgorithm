package org.example.boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/*
수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.

Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표 Xj의 개수와 같아야 한다.

X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.

5
2 4 -10 4 -9

36
1000 999 1000 999 1000 999 1000 999 1000 999 1000 999 1000 999 1000 999 1000 999 1000 999 1000 999 1000 999 1000 999 1000 999 1000 999 1000 999 1000 999 1000 999

2 3 0 3 1

2보다 작은거 -10, -9
4보다 작은거 2, -9 -10
-10 보다 작은거 없음
4 보다 작은거 2 -9 -10
-9 보다 작은거 -10
2 3 0 3 1


*/
public class P18870 {
    //정렬한 리스트가 필요함
    //n이 입력 되면 n보다 작은 값을 이분 탐색으로 찾음

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> coordinate = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());


        List<Integer> sorted = new ArrayList<>(coordinate);
//        sort(sorted, 0, coordinate.size() - 1);
        Collections.sort(sorted);
        System.out.println("sorted = " + sorted);

        int[] unique = sorted.stream().distinct().mapToInt(Integer::intValue).toArray();
        StringJoiner joiner = new StringJoiner(" ");
        for (int i = 0; i < coordinate.size(); i++) {
            int s = binarySearch(unique, coordinate.get(i));
            joiner.add(s + "");
        }

        System.out.println(joiner);
    }

    public static int binarySearch(int[] unique, int n) {

        int left = 0;
        int right = unique.length - 1;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (unique[mid] < n) {
                answer = mid + 1;
                left = mid + 1;
            }
            if (unique[mid] >= n) {
                right = mid - 1;
            }
        }

        return answer;
    }

    public static void sort(List<Integer> coordinate, int low, int high) {
        if (low < high) {
            int partition = partition(coordinate, low, high);
            sort(coordinate, low, partition - 1);
            sort(coordinate, partition + 1, high);
        }
    }

    public static int partition(List<Integer> coordinate, int low, int high) {
        int pivot = coordinate.get(high);
        int l = low - 1;

        for (int i = low; i < high; i++) {
            if (coordinate.get(i) < pivot) {
                l++;
                swap(coordinate, l, i);
            }
        }
        swap(coordinate, l + 1, high);
        return l + 1;
    }
    public static void swap(List<Integer> coordinate, int i, int j) {
        int temp = coordinate.get(i);
        coordinate.set(i, coordinate.get(j));
        coordinate.set(j, temp);
    }
}
