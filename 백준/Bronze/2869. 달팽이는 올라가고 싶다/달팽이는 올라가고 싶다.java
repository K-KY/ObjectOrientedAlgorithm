import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int v = sc.nextInt();

        int dpm = a - b;
        int min = v - a;

        System.out.println((int)Math.ceil((double) min/dpm + 1));
    }
}