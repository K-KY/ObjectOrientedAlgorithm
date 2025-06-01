import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] s = Arrays.stream(new Scanner(System.in).nextLine().split(""))
            .mapToInt(Integer::parseInt).toArray();
        
        int[] counter = new int[10];
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length; i++) {
            counter[s[i]]++;
        }
        
        for (int i = 0; i < counter.length; i++) {
            for (int j = 0; j < counter[i]; j++) {
                sb.append(i);
            }
        }
        
        System.out.println(sb.reverse());
    }
}