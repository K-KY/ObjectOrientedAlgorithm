import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeSet<String> set = new TreeSet<>(Comparator.comparingInt(String::length).thenComparing(String::compareTo));
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String s = in.next();
            set.add(s);
        }
        set.forEach(System.out::println);
    }
}
