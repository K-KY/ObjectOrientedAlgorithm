import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a + b == 0) {
                return;
            }
            System.out.println(a + b);
        }
    }
}