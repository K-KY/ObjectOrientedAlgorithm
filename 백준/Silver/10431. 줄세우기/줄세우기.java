import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        int sb = 0;
        StringBuilder builder = new StringBuilder();
        while (loop-- > 0) {
            sb = 0;
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 1; i < arr.length; i++) {
                int count = 0;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] > arr[j]) {
                        count++;
                    }
                }
                sb+=count;
            }
            builder.append(arr[0]+ " " + sb).append("\n");
        }
        
        System.out.println(builder);

    }
}


