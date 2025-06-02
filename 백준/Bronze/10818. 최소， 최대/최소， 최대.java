import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int len = sc.nextInt();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int n = sc.nextInt();
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        
        System.out.println(min + " " + max);
    }
}