package org.example.boj;

import java.util.*;

public class P2884 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int m = sc.nextInt();

        m = m - 45;

        if (m < 0) {
            m = 60 + m;
            h -= 1;
        }

        if (h < 0) {
            h = 24 + h;
        }

        System.out.println(h + " " + m);
    }
}

