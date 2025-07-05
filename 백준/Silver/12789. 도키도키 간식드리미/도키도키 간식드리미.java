import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = Integer.parseInt(sc.nextLine());
        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Stack<Integer> stack = new Stack<>();
        int line = 1;

        for (int i = 0; i < array.length; i++) {
            while(true) {
                if (!stack.isEmpty() && stack.peek() == line) {
                    stack.pop();
                    line++;
                    continue;
                }
                break;
            }
            if (line == array[i]) {
                line++;
                continue;
            }
            stack.push(array[i]);
        }

        String get = "Nice";

        for (int i = 0; i < stack.size(); i++) {
            if (stack.pop() == line) {
                line++;
                continue;
            }
            get = "Sad";
        }

        System.out.println(get);
    }
}
