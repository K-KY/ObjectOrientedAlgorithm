package org.example.boj;


import java.util.Scanner;

/*
무한히 큰 배열에 다음과 같이 분수들이 적혀있다.

1/1	1/2	1/3	1/4	1/5	1/6
2/1	2/2	2/3	2/4	2/5	2/6
3/1	3/2	3/3	3/4	3/5	3/6
4/1	4/2	4/3	4/4	4/5	4/6
5/1	5/2	5/3	5/4	5/5	5/6
6/1	6/2	6/3	6/4	6/5	6/6

1  2  6  7  15 16 28 29 45
3  5  8  14 17 27 30 44
4  9  13 18 26 31 43
10 12 19 25 32 42
11 20 24 33 41
21 23 34 40
22 35 39
36 38
37
이와 같이 나열된 분수들을 1/1 → 1/2 → 2/1 → 3/1 → 2/2 → … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.

X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.

n - 1 이 홀수일 때 위로 짝수일 때 아래로
== n 이 짝수일 때 위로 홀수일 때 아래로
n이 짝수면 왼쪽값 - 오른쪽값 +
n이 홀수면 왼쪽값 + 오른쪽값 -
 */
public class P1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();

        if (target <= 3) {
            if (target == 1) {
                System.out.println("1/1");
            }
            if (target == 2) {
                System.out.println("1/2");
            }
            if (target == 3) {
                System.out.println("2/1");
            }
            return;
        }

        int n = 0;

        while (n * (n - 1) / 2 < target) {
            n++;
        }

        System.out.println(n);
        int max = n - 1;
        System.out.println(getMove(target, max));
        int move = getMove(target, max);
        System.out.println("move = " + move);
        System.out.println(n - (1 + move));
        System.out.println(1 + move);


    }

    public static int getMove(int target, int max) {
        if (target % max == 0) {
            while (target > max) {
                target -= max;
            }
            return target;
        }
        return target % max;
    }
}
