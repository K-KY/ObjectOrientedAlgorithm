import java.util.*;
public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringJoiner sj = new StringJoiner(" ", "", " int");
        for (int i = 0; i < n; i+=4) {
            sj.add("long");
        }
        System.out.println(sj);
    }
}