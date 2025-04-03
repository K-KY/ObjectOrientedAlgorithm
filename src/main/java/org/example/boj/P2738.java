package org.example.boj;


import java.util.*;

/*
N*M크기의 두 행렬 A와 B가 주어졌을 때, 두 행렬을 더하는 프로그램을 작성하시오.

첫째 줄에 행렬의 크기 N 과 M이 주어진다.
둘째 줄부터 N개의 줄에 행렬 A의 원소 M개가 차례대로 주어진다. 이어서 N개의 줄에 행렬 B의 원소 M개가 차례대로 주어진다.
N과 M은 100보다 작거나 같고, 행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다.

3 3
N줄
1 1 1 -> M개
2 2 2
0 1 0
3 3 3
4 4 4
5 5 100

4 4 4
6 6 6
5 6 100

문제 뭔 말 하는지 이해안되고 대충 보니까 N줄 M행 인거 같음

N 번 반복 M*2번 반복
M번 반복 첫번쨰는 저장
두 번째는 저장된 행에 더하기
저장된 행 Joiner 써서 출력

* */
public class P2738 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int[] condition = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        List<int[]> result = new ArrayList<>();
//        for (int i = 0; i < condition[0]; i++) {
//            int[] arr = new int[condition[1]];
//            for (int j = 0; j < condition[1]; j++) {
//                arr[j] = sc.nextInt();
//            }
//            result.add(arr);
//        }
//        for (int i = 0; i < condition[0]; i++) {
//            int[] arr = new int[condition[1]];
//            for (int j = 0; j < condition[1]; j++) {
//                arr[j] = sc.nextInt();
//                result.get(i)[j] += arr[j];
//            }
//        }
//
//        result.stream().map(arr -> {
//            StringJoiner stringJoiner = new StringJoiner(" ");
//            Arrays.stream(arr).boxed().map(String::valueOf).forEach(stringJoiner::add);
//            return stringJoiner.toString();
//        }).forEach(System.out::println);

        Scanner sc = new Scanner(System.in);
        int[] condition = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < condition[0]; i++) {
            int[] arr = new int[condition[1]];
            for (int j = 0; j < condition[1]; j++) {
                arr[j] = sc.nextInt();
            }
            result.add(arr);
        }
        for (int i = 0; i < condition[0]; i++) {
            int[] arr = new int[condition[1]];
            for (int j = 0; j < condition[1]; j++) {
                arr[j] = sc.nextInt();
                System.out.println(result.get(i)[j] + arr[j] + " ");
            }
            System.out.println();
        }


    }
}
