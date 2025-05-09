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
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));;
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[] grd = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] cmd = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int[] xyd = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            cmd[xyd[0] - 1] += xyd[2];
            cmd[xyd[1]] += -xyd[2];
        }

        int stack = 0;
        for (int i = 0; i < n; i++) {
            stack += cmd[i];
            grd[i] += stack;
            bw.write(grd[i] + " ");
        }
        bw.flush();
    }
}
