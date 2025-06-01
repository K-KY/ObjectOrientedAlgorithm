import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        
        int[] a = new int[len];
        int[] b = new int[len];
        int sum = 0;

        for (int i = 0; i < len; i++) {
          a[i] = sc.nextInt();
        }
        for (int i = 0; i < len; i++) {
          b[i] = sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        
        for (int i = 0; i < a.length; i++) {
                sum = sum + a[i] * b[b.length - 1 - i];
        }
        System.out.println(sum);
    }
}