import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        int n = in.nextInt();
        StringBuilder sb = new StringBuilder();
        while (target > 0) {
            if (target % n >= 10) {
                sb.append((char) (target % n + 'A' - 10));
                target = target / n;
                continue;
            }
            sb.append(target % n);
            target = target / n;
        }
        System.out.println(sb.reverse());
    }
}
