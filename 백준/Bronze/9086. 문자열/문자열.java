import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int roop = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < roop; i++) {
            String str = sc.nextLine();
            sb.append(str.charAt(0) + "");
            sb.append(str.charAt(str.length() - 1) + "");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}