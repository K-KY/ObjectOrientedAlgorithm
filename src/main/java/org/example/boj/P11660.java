package org.example.boj;

import java.util.Arrays;
import java.util.Scanner;

/*
N×N개의 수가 N×N 크기의 표에 채워져 있다. (x1, y1)부터 (x2, y2)까지 합을 구하는 프로그램을 작성하시오. (x, y)는 x행 y열을 의미한다.

예를 들어, N = 4이고, 표가 아래와 같이 채워져 있는 경우를 살펴보자.

1	2	3	4
2	3	4	5
3	4	5	6
4	5	6	7

1	2	3	4   2	3	4	5   3	4	5	6   4	5	6	7

    1 3 6 10
    2 5 9 15
    3 7 12 18
    4 9 15 21

여기서 (2, 2)부터 (3, 4)까지 합을 구하면 3+4+5+4+5+6 = 27이고, (4, 4)부터 (4, 4)까지 합을 구하면 7이다.
2, 2 부터 3, 2까지 [y - 1] [x - 1] - [y - 1] [x - 2]
3, 3 부터 3, 3까지
3, 3 부터 3, 4까지

sx = 2 sy = 2
ex = 3 ey = 4

표에 채워져 있는 수와 합을 구하는 연산이 주어졌을 때, 이를 처리하는 프로그램을 작성하시오.

4 3
1 2 3 4    1 3 6 10
2 3 4 5    2 5 9 14
3 4 5 6    3 7 12 18
4 5 6 7    4 9 15 22


[ey - 1][ex - 1] - [ey - 1][sx - 2] - [sy - 1][ey - 1]
27 - 6 - 6 + 1(중복값) = 16

1  3  6  10
12 15 19 24
27 31 36 42
46 51 57 64

2 2 3 4 | 7 9 11
3 4 3 4 | 6
1 1 4 4 | 10 14 18 22

27
6
64


 */
public class P11660 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int frameSize = sc.nextInt();
        int cmdSize = sc.nextInt();
        int[][] frame = new int[frameSize +1][frameSize +1];


        /*

1 2 3 4 i 가 0이면 x 누적합, j 가 0이면 y누적합만 둘 다 0이면 단순 입력
2 3 4 5
3 4 5 6
4 5 6 7

1 3 6 10
3 8 15 24
6 15 27 42
10 24 42 64
*/
        for (int i = 1; i <= frameSize; i++) {
            for (int j = 1; j <= frameSize; j++) {
                if (j == 1) {
                    frame[i][j] = sc.nextInt();
                    continue;
                }
                frame[i][j] = frame[i][j - 1] + sc.nextInt();

            }
        }

        for (int i = 1; i <= frameSize; i++) {
            for (int j = 1; j <= frameSize; j++) {
                frame[i][j] += frame[i - 1][j];
            }
        }



        for (int[] ints : frame) {
            System.out.println(Arrays.stream(ints).boxed().toList());
        }
        for (int i = 0; i < cmdSize; i++) {
            int sX = sc.nextInt();//2
            int sY = sc.nextInt();//2
            int eX = sc.nextInt();//3
            int eY = sc.nextInt();//4
            System.out.println("frame[eY][eX] = " + frame[eY][eX]);
            System.out.println("(- frame[eY][sX - 1]) = " + (-frame[eY][sX - 1]));
            System.out.println("( - frame[sY - 1][eX]) = " + (-frame[sY - 1][eX]));
            System.out.println("frame[sY - 1][sX - 1] = " + frame[sY - 1][sX - 1]);
            System.out.println("frame[eX][eY] = " + frame[eX][eY]);
            System.out.println("(- frame[sX - 1][eY]) = " + (-frame[sX - 1][eY]));
            System.out.println("( - frame[eX][sY - 1]) = " + (-frame[eX][sY - 1]));
            System.out.println("frame[sX - 1][sY - 1] = " + frame[sX - 1][sY - 1]);

            int result = frame[eY][eX] - frame[eY][sX - 1] - frame[sY - 1][eX] + frame[sY - 1][sX - 1];
            int result2 = frame[eX][eY] - frame[sX - 1][eY] - frame[eX][sY - 1] + frame[sX - 1][sY - 1];
            System.out.println("result1" + result);
            System.out.println("result2" + result2);
//            int sX = sc.nextInt();//2
//            int sY = sc.nextInt();//2
//            int eX = sc.nextInt();//3
//            int eY = sc.nextInt();//4
//            System.out.println("frame[eX][eY] = " + frame[eX][eY]);
//            System.out.println("(- frame[sX - 1][eY]) = " + (-frame[sX - 1][eY]));
//            System.out.println("( - frame[eX][sY - 1]) = " + (-frame[eX][sY - 1]));
//            System.out.println("frame[sX - 1][sY - 1] = " + frame[sX - 1][sY - 1]);
//            int result = frame[eX][eY] - frame[sX - 1][eY] - frame[eX][sY - 1] + frame[sX - 1][sY - 1];
//            System.out.println(result);
        }
        for (int[] ints : frame) {
            System.out.println(Arrays.stream(ints).boxed().toList());
        }
    }
    public static int limit(int a) {
        return Math.max(a, 0);
    }
}
//