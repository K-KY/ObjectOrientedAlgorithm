package org.example.boj;


/*
2020년 5월 14일 논산훈련소에 입대한 태상이는 첫 총기 훈련에서 가스 조절기를 잃어버리는 중대한 실수를 범했다.
그로 인해, 태상이는 조교들에게 눈총을 받게 되었다. 조교들은 태상이에게 연병장(운동장)의 흙을 옮기는 일을 주고 제대로 수행하지 못하면 징계를 내리려고 한다.

연병장은 일렬로 이어진 N개의 칸으로 이루어져 있으며 각 칸마다 높이를 가지고 있고, 첫 번째 칸부터 순서대로 1번, 2번, 3번, ..., N번 칸으로 명칭이 붙어있다.
 조교들은 총 M명이 있으며, 각 조교들은 태상이에게 a번 칸부터 b번 칸까지 높이 k만큼 흙을 덮거나 파내라고 지시한다.
 흙은 주변 산에서 얼마든지 구할 수 있으므로 절대로 부족하지 않다.

태상이는 각 조교의 지시를 각각 수행하면, 다른 조교의 지시로 흙을 덮어둔 칸을 다시 파내기도 하는 비효율적인 일이 발생하는 것을 깨달았다.
그래서 태상이는 각 조교의 지시를 모아 연병장 각 칸의 최종 높이를 미리 구해 한 번에 일을 수행하려고 한다.

불쌍한 태상이를 위해 조교들의 지시를 모두 수행한 뒤 연병장 각 칸의 높이를 구하자.

첫 줄에 연병장의 크기 N과 조교의 수 M이 주어진다.

둘째 줄에 연병장 각 칸의 높이 Hi가 순서대로 N개 주어진다.

셋째 줄부터 M개의 줄에 각 조교의 지시가 주어진다.

각 조교의 지시는 세 개의 정수 a, b, k로 이루어져 있다.

k ≥ 0인 경우 a번 칸부터 b번 칸까지 높이가 각각 |k| 만큼 늘어나도록 흙을 덮어야 한다.
k < 0인 경우 a번 칸부터 b번 칸까지 높이가 각각 |k| 만큼 줄어들도록 흙을 파내야 한다.

모든 지시를 수행한 뒤 연병장 각 칸의 높이를 공백을 사이에 두고 출력한다.

10 3
1 2 3 4 5 -1 -2 -3 -4 -5
1 5 -3
6 10 5
2 7 2

-2 1 2 3 4 6 5 2 1 0
-2 1 2 3 4 6 5 2 1 0
-2 1 2 3 4 6 5 2 1 0

1 2 3 4 5 -1 -2 -3 -4 -5

-2 1 2 3
stack = -3
stack = -1
-2 1 2 3
 */

/*
 * n m 입력받기
 * 배열 입력 받기
 * 입력받은 배열의 길이만큼의 배열 새로 만들기
 * 좌표 입력 받기
 * 좌표의 x 에 i 를 새로 만든 배열에 저장
 * 좌표의 y 에 -i 를 새로 만든 배열에 저장
 * 새로 만든 좌표를 순회
 * i번째 인덱스 값만큼 스택에 추가
 * 스택만큼 운동장의 i에 추가
 * */

import java.io.*;
import java.util.Scanner;
import java.util.StringJoiner;

public class P19951 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] grd = new int[n];
        int[] cmd = new int[n + 1];
        for (int i = 0; i < n; i++) {
            grd[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();
            cmd[x - 1] += d;
            cmd[y] += -d;
        }

        int stack = 0;
        for (int i = 0; i < n; i++) {
            stack += cmd[i];
            grd[i] += stack;

        }
        StringJoiner sj = new StringJoiner(" ");
        for (int i : grd) {
            sj.add(Integer.toString(i));
        }
        System.out.println(sj);
    }
}
