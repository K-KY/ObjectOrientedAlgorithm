package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for (int i = 0; i< cases; i++) {
            String[] tokens = br.readLine().split(" ");
            solve(Integer.parseInt(tokens[0]), tokens[1]);
        }

    }

    public static void solve(int r, String str) throws IOException {
        for (int i = 0; i< str.length(); i++) {
            System.out.print((str.charAt(i)+"").repeat(r));
        }
        System.out.println();
    }
}
