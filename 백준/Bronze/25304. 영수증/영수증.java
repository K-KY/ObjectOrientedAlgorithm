import java.util.*;

public class Main {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        
        int sum = sc.nextInt();
        int len = sc.nextInt();
        
        int check = 0;
        for (int i = 0; i < len; i++) {
            int p = sc.nextInt();
            int n = sc.nextInt();
            
            check+=p * n;
        }
        
        System.out.println(sum == check ? "Yes" : "No");
    }
}