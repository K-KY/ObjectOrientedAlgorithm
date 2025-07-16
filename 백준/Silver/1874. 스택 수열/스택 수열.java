import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> inputs = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int l = sc.nextInt();
        int i = 0;
        int j = 0;
        while (true) {
            int input = sc.nextInt();
            inputs.add(input);
            i++;
            for (; j < l; j++) {
                if (stack.isEmpty() || stack.peek() < input) {
                    stack.push(j + 1);
                    append(sb, "+");
                    continue;
                }

                if (stack.peek() >= input) {
                    Integer pop = stack.pop();
                    list.add(pop);
                    append(sb, "-");
                    break;
                }
            }


            if (i == j && j == l) {
                break;
            }
        }


        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                list.add(stack.pop());
                append(sb, "-");
            }
        }


        if (!inputs.equals(list)) {
            System.out.println("NO");
            return;
        }
        System.out.println(sb);
    }

    public static void append(StringBuilder sb, String s) {
        sb.append(s).append("\n");
    }
}