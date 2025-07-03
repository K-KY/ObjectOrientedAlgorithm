package org.example.boj;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class p2840 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        Circular circular = new Circular(n);

        for (int i = 0; i < k; i++) {
            boolean check = circular.positionShift(in.nextInt(), in.next());
            if (!check) {
                System.out.println("!");
                return;
            }
        }
        System.out.println(circular.printCurrentCircular());
    }
}

class Circular {
    private final String[] items;
    private int currentPosition = 0;

    public Circular(int n) {
        items = new String[n];
    }

    public boolean positionShift(int n, String item) {
        int nextPosition = currentPosition + n;
        if (nextPosition >= items.length) {
            nextPosition %= items.length;
        }
        if (items[nextPosition] != null && !items[nextPosition].equals(item)) {
            return false;
        }
        if (Arrays.asList(items).contains(item) && items[nextPosition] == null) {
            return false;
        }
        items[nextPosition] = item;
        currentPosition = nextPosition;
        return true;
    }

    public String printCurrentCircular() {
        StringBuilder sb = new StringBuilder();
        int pos = currentPosition;
        for (int i = 0; i < items.length; i++) {
            if (items[pos] != null) {
                sb.append(items[pos].trim());
            }
            if (items[pos] == null) {
                sb.append("?");
            }
            pos--;
            if (pos < 0) {
                pos = items.length - 1;
            }
        }
        return sb.toString();
    }
}
//[1][2][3][4][5][6]
//cp = 3 n = 4 -> 7
//7 - 6 = 1
/*
? A ? B ?
2 1
1 A
2 B
3 C

2 2
1 A
2 B

8 16
4 V
3 I
7 T
7 A
6 R
5 N
1 O
9 H
4 V
3 I
7 T
7 A
6 R
5 N
1 O
9 H

A ? B ? ? C
**/