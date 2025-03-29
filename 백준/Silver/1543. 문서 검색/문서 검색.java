import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        String search = sc.nextLine();
        System.out.println((target.length() - target.replace(search, "").length()) / search.length());
    }
}