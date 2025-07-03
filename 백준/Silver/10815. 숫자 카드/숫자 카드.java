import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            set.add(in.nextInt());
        }

        StringJoiner sj = new StringJoiner(" ");

        int compare = in.nextInt();
        for (int i = 0; i < compare; i++) {
            sj.add(set.contains(in.nextInt()) ? "1":"0");
        }

        System.out.println(sj);
    }
}