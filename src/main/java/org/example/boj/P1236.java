package org.example.boj;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*영식이는 직사각형 모양의 성을 가지고 있다.
성의 1층은 몇 명의 경비원에 의해서 보호되고 있다.
영식이는 모든 행과 모든 열에 한 명 이상의 경비원이 있으면 좋겠다고 생각했다.

성의 크기와 경비원이 어디있는지 주어졌을 때, 몇 명의 경비원을 최소로 추가해야 영식이를 만족시키는지 구하는 프로그램을 작성하시오.

4 4
....
....
....
....

//행의 갯수 만큼 배열 = M
//열의 갯수 만큼 배열 = N
//int[] horizon = new int[M]
//int[] vertical = new int[N]
//행의 갯수만큼 입력 반복
//
//입력에 X가 존재한다면 그 회차번의 horizon 배열 +1
//입력의 길이만큼 탐색
//입력의 n번째가 X라면 그 회차번의 vertical 배열 +1
//
//horizon의 0 갯수 합
//vertical의 0 갯수 합
//둘 중 더 큰 값 출력



*/
public class P1236 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] vertical = new int [input[0]];
        int[] horizontal = new int [input[1]];
        for (int i = 0; i < vertical.length; i++) {
            String line = sc.nextLine();
            if (line.contains("X")) {
                vertical[i] = 1;
            }
            for (int j = 0; j < horizontal.length; j++) {
                if (line.charAt(j) == 'X') {
                    horizontal[j] = 1;
                }
            }
        }

        int hSum = Arrays.stream(horizontal).filter(t -> t == 0).toArray().length;
        int vSum = Arrays.stream(vertical).filter(v -> v == 0).toArray().length;
        System.out.println(Math.max(hSum, vSum));

    }
}
