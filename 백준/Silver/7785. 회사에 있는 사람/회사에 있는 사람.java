import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Map<String, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            String[] split = in.nextLine().split(" ");
            map.put(split[0], isEnter(split[1]));
        }
        map.forEach((k, v) -> {
            if (map.get(k) != 0) {
                System.out.println(k);
            }
        });
    }

    private static int isEnter(String enter) {
        if (Objects.equals(enter, "enter")) {
            return 1;
        }
        return 0;
    }
}
