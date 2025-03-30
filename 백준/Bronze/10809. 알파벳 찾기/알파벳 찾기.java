import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 'a'; i <= 'z'; i++) {
            sj.add(str.indexOf((char)i) + "");
        }
        System.out.println(sj);
    }
}