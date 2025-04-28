import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Integer, TreeSet<String>> map = new HashMap<>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String s = in.next();
            TreeSet<String> treeSet = map.getOrDefault(s.length(), new TreeSet<>());
            treeSet.add(s);
            map.putIfAbsent(s.length(), treeSet);
        }

        for (int i = 1; i <= 50; i++) {
            TreeSet<String> treeSet = map.getOrDefault(i, new TreeSet<>());
            if (treeSet.isEmpty()) {
                continue;
            }
            for (String s : treeSet) {
                System.out.println(s);
            }
        }
    }
}
