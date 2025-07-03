package org.example.boj;

//https://www.acmicpc.net/problem/16713

import java.util.Arrays;
import java.util.Scanner;

public class P16713 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] xor = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            xor[i] = xor[i - 1] ^ sc.nextInt();
        }

        System.out.println(Arrays.stream(xor).boxed().toList());

        int result = 0;
        for (int i = 0; i < q; i++) {
            System.out.println("result = " + result);
            int s = sc.nextInt();
            int e = sc.nextInt();
            System.out.println("(s - 1) = " + (s - 1));
            System.out.println("e = " + e);
            int xo = xor[s - 1] ^ xor[e];
            result ^= xo;
        }

        System.out.println(result);
    }
}
/*
5 4
4 4 2 1 0
1 1
1 2
1 3
2 4

5 3
4 4 4 4 4
1 1
1 2
1 3

*/