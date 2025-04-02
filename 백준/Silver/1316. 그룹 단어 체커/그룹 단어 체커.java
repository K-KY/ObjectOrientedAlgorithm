import java.io.*;
import java.util.*;
public class Main {
        public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(reader.readLine());
        int a = 0;
        for (int j = 0; j < i; j++) {
            String s = reader.readLine();

            if (isTrue(s)) {
                a++;
            }

        }
        System.out.println(a);
    }

    public static boolean isTrue(String s) {
        char prev = '@';
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (prev != s.charAt(i) && chars.contains(s.charAt(i))) {
                return false;
            }
            chars.add(s.charAt(i));
            prev = s.charAt(i);
        }
        return true;
    }

}