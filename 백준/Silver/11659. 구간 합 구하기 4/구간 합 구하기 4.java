import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int suNo = Integer.parseInt(st.nextToken());
        int quizNo = Integer.parseInt(st.nextToken());

        long[] s = new long[suNo + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=suNo; i++){
            s[i] = s[i-1] + Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<quizNo; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(s[b]-s[a-1]);
        }
    }

}