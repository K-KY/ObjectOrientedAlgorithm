import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        List<String> chars = Stream.of(in.next().split("")).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.size(); i++) {
            if (s.contains(chars.get(i))) {
                continue;
            }
            sb.append(chars.get(i));
        }
        System.out.println(sb);
    }
}
