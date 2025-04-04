import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine().trim().replaceAll("\\+", "");
        int xIndex = target.indexOf("x");
        if (xIndex != -1) {
            String substring = target.substring(0, xIndex);
            if (Objects.equals(substring, "-")) {
                System.out.println(-1);
                return;
            }
            if (Objects.equals(substring, "")) {
                System.out.println(1);
                return;
            }
            System.out.println(Integer.parseInt(substring));
        }
        if (xIndex == -1) {
                System.out.println(0);
        }

    }
}