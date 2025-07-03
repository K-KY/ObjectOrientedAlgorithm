import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Set<String> set = new HashSet<>();

        int end ;
        int len = 1;

        while (len <= s.length()) {
            end = len;
            for (int i = 0; i < s.length(); i++) {
                if (end > s.length()) {
                    break;
                }
                set.add(s.substring(i, end));
                end++;
            }
            len++;
        }

        System.out.println(set.size());
    }
}