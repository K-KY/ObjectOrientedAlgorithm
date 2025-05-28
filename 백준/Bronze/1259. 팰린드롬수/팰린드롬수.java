import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.setLength(0);
            String s = sc.nextLine();
            if (s.equals("0")) {
                break;
            }
            s.chars().forEach(c -> sb.append((char) c));
            sb.reverse();
            if (Objects.equals(s, sb.toString())) {
                System.out.println("yes");
                continue;
            }
            System.out.println("no");
        }
    }
}
