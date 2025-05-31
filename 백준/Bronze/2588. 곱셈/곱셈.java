import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = toInt(sc.next());
        int b = toInt(sc.next());
        
        String[] brr = String.valueOf(b).split("");
        for (int i = 0; i < brr.length; i++) {
            int c = toInt(brr[brr.length - 1 - i]);
            int s = c * a;
            System.out.println(s);
        }
        
        System.out.println(a * b);
    }
    
    static int toInt(String s) {
        return Integer.parseInt(s);
    }
}