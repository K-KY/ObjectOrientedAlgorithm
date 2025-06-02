import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int target = sc.nextInt();
        
        
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < len; i++) {
            int n = sc.nextInt();
            if (n < target) {
                sj.add(n + "");
            }
        }
        System.out.println(sj);
    }
}