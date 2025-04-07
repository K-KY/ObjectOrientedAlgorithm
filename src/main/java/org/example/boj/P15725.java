package org.example.boj;

import java.util.Scanner;

public class P15725 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        int scope = 0;
        if (target.contains("x")) {
            while (!target.isBlank() && target.charAt(scope) != 'x') {
                scope++;
            }

            if (target.startsWith("x") || target.startsWith("-x")) {
                System.out.println(target.substring(0, scope + 1).replace("x", "1"));
            }
            else {
                System.out.println(target.substring(0, scope + 1).replace("x", ""));
            }
        }

    }
}
