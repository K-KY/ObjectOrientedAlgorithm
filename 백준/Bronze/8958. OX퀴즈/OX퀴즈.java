/*5
OOXXOXXOOO
OOXXOOXXOO
OXOXOXOXOXOXOX
OOOOOOOOOO
OOOOXOOOOXOOOOX
*/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int len = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < len; i++) {
            String[] s = sc.nextLine().split("");
            int score = 0;
            int stack = 0;
            for (int j = 0; j < s.length; j++) {
                if ("O".equals(s[j])) {
                    stack += 1;
                    score += stack;
                }
                if ("X".equals(s[j])) {
                    stack = 0;
                }
            }
            System.out.println(score);
        }
    }
}