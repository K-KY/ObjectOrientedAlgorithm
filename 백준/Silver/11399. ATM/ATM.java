import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int e = sc.nextInt();
            list.add(e);
        }
        list.sort(Integer::compareTo);


        int wait = 0;
        int total = 0;
        for (int i = 0; i < list.size(); i++) {
            Integer p = list.get(i);
            wait = p + wait;
            total += wait;
        }

        System.out.println(total);
    }
}
// 1 3 6 9 13