import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = Integer.parseInt(sc.nextLine());
        boolean flag;

        StringJoiner joiner = new StringJoiner("\n");

        for (int i = 0; i < len; i++) {
            VPSStack stack = new VPSStack();
            flag = true;
            String[] vps = sc.nextLine().split("");
            for (int j = 0; j < vps.length; j++) {

                if (vps[j].equals("(")) {
                    stack.push(vps[j]);
                    continue;
                }
                if (vps[j].equals(")")) {
                    boolean pop = stack.pop();
                    if (!pop) {
                        flag = false;
                        break;
                    }
                }
            }
            if (!flag || stack.size() > -1) {
                joiner.add("NO");
                continue;
            }
            joiner.add("YES");
        }
        System.out.println(joiner);

    }
}

class VPSStack {
    String[] stack;
    int size;

    public VPSStack() {
        stack = new String[10];
        size = -1;
    }

    public void push(String x) {
        if (size == stack.length - 1) {
            String[] newStack = new String[size + 10];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
        stack[++size] = x;
    }

    public boolean pop() {
        if (size > -1) {
            stack[size] = null;
            size--;
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(stack);
    }
}
