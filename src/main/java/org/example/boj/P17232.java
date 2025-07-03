package org.example.boj;

/*

바둑판의 각 칸은 주위의 영향을 받는데,
 주위란 <그림2>에서 색칠한 영역과 같이 현재 칸을 중심으로 둔 한 변의 길이가 (2K + 1) 인 정사각형에서 현재 칸을 제외한 영역을 말한다.

바둑판의 각 칸은 주위에 몇 개의 생명이 존재하는지에 따라 다음 상황이 아래와 같이 결정된다.

생존 : 만약 현재 칸에 생명이 있고, 주위에 a개 이상 b개 이하의 생명이 있다면 현재 칸의 생명은 다음 단계에 살아남는다.
고독 : 만약 현재 칸에 생명이 있고, 주위에 a개 미만의 생명이 있다면 현재 칸의 생명은 외로워서 죽는다.
과밀 : 만약 현재 칸에 생명이 있고, 주위에 b개 초과의 생명이 있다면 현재 칸의 생명은 과밀로 죽는다.
탄생 : 만약 현재 칸에 생명이 없고, 주위에 a개 초과 b개 이하의 생명이 있다면 다음 단계에서 현재 칸에 생명이 생긴다.
생명은 바둑판을 벗어난 영역에서는 생존할 수 없다.

준표는 N×M 크기의 바둑판에 생명을 뿌리고, T시간 뒤의 생명을 관찰하고자 한다.

6 6 1
1 2 3
.*....
..*...
***...
......
......
......
6 6 7
1 2 3
.*....
..*...
***...
......
......
......
바둑판 세로 6 바둑판 가로 6
관찰 시간 7
K == 1
a == 2
b == 3

2K + 1 = 3
......
..*...
***...
......
......
......



*/

import java.util.Scanner;
import java.util.StringTokenizer;

public class P17232 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //세로
        int m = sc.nextInt(); //가로
        int t = sc.nextInt(); //관찰 시간
        int k = sc.nextInt(); //범위
        int max = sc.nextInt(); //최대 생명
        int min = sc.nextInt(); //최소 생명
        char[][] origin = new char[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String str = sc.next();
            for (int j = 1; j <= m; j++) {
                origin[i][j] = str.charAt(j - 1);
            }
        }

        print(origin);
        System.out.println();

        while (t-- > 0) {
            int[][] arr = getSum(origin);
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    int near = getNear(arr, i, j, k);
                    if (origin[i][j] == '*') {
                        near--;
                        if (near < min || near > max) {
                            origin[i][j] = '.';
                        }
                    }
                    if (min < near && max >= near) {
                        origin[i][j] = '*';
                    }
                }
            }
        }

        print(origin);


    }

    private static int getNear(int[][] arr, int i, int j, int k) {
        int r1 = Math.max(i - k, 1);
        int c1 = Math.max(j - k, 1);
        int r2 = Math.min(i + k, 1);
        int c2 = Math.min(j + k, 1);
        return arr[r2][c2] - arr[r2 - 1][c2] - arr[r1 - 1][c2] + arr[r1 - 1][c1 - 1];
    }

    public static int[][] getSum(char[][] origin) {
        int[][] arr = new int[origin.length][origin[0].length];
        for (int i = 1; i < origin.length; i++) {
            for (int j = 1; j < origin[0].length; j++) {

                arr[i][j] = arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
                if (origin[i][j] == '*') {
                    arr[i][j] += 1;
                }
            }
            print(arr);
            System.out.println();
        }
        return arr;
    }

    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void print(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int convert(String s) {
        if (s.equals(".")) {
            return 0;
        }
        return 1;
    }

}

/*

, , , , , , ,
, 0 1 1 1 1 1
, 0 1 2 2 2 2
, 1 3 5 5 5 5
, 1 3 5 5 5 5
, 1 3 5 5 5 5
, 1 3 5 5 5 5

0 0 0 0 0 0 0
0 0 1 1 1 1 1
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0



* */
