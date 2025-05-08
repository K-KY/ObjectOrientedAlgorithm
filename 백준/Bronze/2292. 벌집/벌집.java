import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int max = 1;
        int i = 0;
        int r = 0;
        while (max < n) {
            i+=6;
            max+=i;
            r++;
        }
        System.out.println(r + 1);
    }
}