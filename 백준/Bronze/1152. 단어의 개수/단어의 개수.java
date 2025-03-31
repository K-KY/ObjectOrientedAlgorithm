import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        if (target.trim().length() == 0) {
            System.out.println(0);
        }
        if (target.trim().length() != 0) {
        System.out.println(target.trim().split(" ").length);
        }
        
    }
}