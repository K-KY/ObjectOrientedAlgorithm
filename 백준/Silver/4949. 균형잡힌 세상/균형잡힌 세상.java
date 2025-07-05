import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String sqOpen = "[";
        String sqClose = "]";
        String roundOpen = "(";
        String roundClose = ")";

        boolean flag;

        StringJoiner joiner = new StringJoiner("\n");
        while (true) {
            BracketStack bracketStack = new BracketStack();
            flag = true;
            String line = sc.nextLine();
            for (int i = 0; i < line.length(); i++) {
                String s = line.charAt(i) + "";
                if (s.equals(roundOpen) || s.equals(sqOpen)) {
                    bracketStack.push(s);
                }

                if (s.equals(roundClose)) {
                    String pop = bracketStack.pop();
                    if (!pop.equals(roundOpen)) {
                        flag = false;
                        break;
                    }
                    continue;
                }

                if (s.equals(sqClose)) {
                    String pop = bracketStack.pop();
                    if (!pop.equals(sqOpen)) {
                        flag = false;
                        break;
                    }
                }
            }

            if (line.equals(".")) {
                break;
            }


            if (!flag || bracketStack.size() !=  -1) {
                joiner.add("no");
                continue;
            }
            if (flag) {
                joiner.add("yes");
            }


        }
        System.out.println(joiner);
    }
}

class BracketStack {
    String[] stack;
    int size;

    public BracketStack() {
        stack = new String[10];
        size = -1;
    }

    public void grow() {
        String[] newStack = new String[stack.length + 10];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }

    public void push(String x) {
        if (size == stack.length -1) {
            grow();
        }
        stack[++size] = x;
    }

    public String pop() {
        if (size == -1) {
            return "";
        }
        String s = stack[size];
        stack[size] = null;
        size--;
        return s;
    }

    public int size() {
        return size;
    }
}
