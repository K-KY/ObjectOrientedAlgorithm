import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int score = 0;
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int obj = Integer.parseInt(br.readLine());
        Collections.sort(list);
        int start = 0;
        int end = list.size() - 1;
            while (start < end) {
                if (list.get(start) + list.get(end) == obj) {
                    score++;
                    start++;
                    end--;
                }
                if (list.get(start) + list.get(end) > obj) {
                    end--;
                }
                if (list.get(start) + list.get(end) < obj) {
                    start++;
                }
            }

        System.out.println(score);
    }
}
