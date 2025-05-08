import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int origin = 2;
        
        for (int i = 0 ; i < n; i++) {
            origin = origin + (origin - 1);
        }
        System.out.println(origin * origin);
    }
}