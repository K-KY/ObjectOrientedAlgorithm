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

public class Main {
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
        int grdIdx = 0;
        for (int i = 0; i < n; i++) {
            stack += cmd[i];
            grd[grdIdx++] += stack;

        }
        StringJoiner sj = new StringJoiner(" ");
        for (int i : grd) {
            sj.add(Integer.toString(i));
        }
        System.out.println(sj);
    }
}
