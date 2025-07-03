package org.example.boj;

import java.io.*;
import java.util.HashMap;

public class P2750 {
    public static void main(String[] args) throws IOException {
        HashMap<Integer, Integer> hash = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int lines = Integer.parseInt(br.readLine());
        for (int i = 0; i < lines; i++) {
            int n = Integer.parseInt(br.readLine());
            hash.put(n, n);
        }
        hash.keySet().stream().sorted().toList().forEach(i -> {
            try {
                bw.write(i+"\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        bw.flush();
    }
}
