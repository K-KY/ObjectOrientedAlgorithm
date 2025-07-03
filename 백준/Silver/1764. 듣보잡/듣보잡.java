import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nlNll = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        HashMap<String, Boolean> nlMap = new HashMap<>();

        for (int i = 0; i < nlNll[0]; i++) {
            nlMap.put(sc.nextLine(), true);
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < nlNll[1]; i++) {
            String key = sc.nextLine();
            if (nlMap.get(key) != null) {
                list.add(key);
            }
        }
        System.out.println(list.size());
        list.sort(String::compareTo);
        list.forEach(System.out::println);
    }
}