import java.util.*;
public class Main {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ab = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Set<String> set = new HashSet<>(Arrays.asList(sc.nextLine().split(" ")));



        int sub = ab[0] + ab[1];
        String[] array = sc.nextLine().split(" ");
        for (String s : array) {
            if (set.contains(s)) {
                sub-=2;
            }
        }
        System.out.println(sub);
    }
}