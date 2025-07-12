import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int[] qs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] values = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < qs.length; i++) {
            if (qs[i] == 0) {
                stack.offerLast(values[i]);
            }
        }

        int l = Integer.parseInt(br.readLine());
        int[] push = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int temp;
        for (int i = 0; i < push.length; i++) {
            temp = push[i];
            stack.push(temp);
            bw.write(stack.pollLast() + " ");
        }
        bw.flush();
    }
}
