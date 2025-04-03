package org.example.boj;

import java.util.Arrays;
import java.util.Scanner;

public class P2941 {
    public static void main(String[] args) {
        String[] alphabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        for (int i = 0; i < alphabet.length; i++) {
            str = str.replace(alphabet[i], "#*");
        }
        System.out.println(str.split("#").length - 1 + str.replace("#*", "").length());

    }
}
//.e..ak
