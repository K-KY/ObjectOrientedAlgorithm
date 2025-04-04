import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        int[] count = new int[10_000_000];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int loop = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < loop; i++) {
            count[Integer.parseInt(br.readLine()) - 1]++;
        }
        
        for (int i = 0; i < count.length; i++) {
            bw.write((i + 1 + "\n").repeat(count[i]));
        }
        bw.flush();
    }
}