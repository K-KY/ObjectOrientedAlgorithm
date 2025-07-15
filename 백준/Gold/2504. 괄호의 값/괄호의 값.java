import java.util.*;
public class Main {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Object> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else {
                int value = 0;

                while (!stack.isEmpty() && stack.peek() instanceof Integer) {
                    value += (int) stack.pop();
                }

                if (stack.isEmpty()) {
                    System.out.println(0);
                    return;
                }

                char open = (char) stack.pop();

                if ((ch == ')' && open != '(') || (ch == ']' && open != '[')) {
                    System.out.println(0);
                    return;
                }

                if (value == 0) {
                    stack.push(ch == ')' ? 2 : 3);
                } else {
                    stack.push((ch == ')') ? 2 * value : 3 * value);
                }
            }
        }

        int result = 0;
        for (Object obj : stack) {
            if (obj instanceof Character) {
                System.out.println(0);
                return;
            } else {
                result += (int) obj;
            }
        }
        System.out.println(result);
    }

}