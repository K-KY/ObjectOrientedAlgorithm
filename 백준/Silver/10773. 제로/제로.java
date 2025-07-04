import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MiniStack miniStack = new MiniStack();

        int l = scanner.nextInt();

        for (int i = 0; i < l; i++) {

            int x = scanner.nextInt();
            if (x == 0) {
                miniStack.pop();
                continue;
            }
            miniStack.push(x);
        }
        System.out.println(miniStack.sum());
    }
}

class MiniStack {
    int[] stack;
    int size;

    public MiniStack() {
        this.stack = new int[10];
        this.size = -1;
    }

    public void push(int x) {
        if (size == stack.length - 1) {
            int[] newStack = new int[stack.length * 2];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
        stack[++size] = x;
    }

    public int pop() {
        if (size == -1) {
            return 0;
        }
        int i = stack[size];
        stack[size--] = 0;
        return i;
    }

    public int peek() {
        if (size == -1) {
            return 0;
        }
        return stack[size];
    }

    public int sum() {
        return Arrays.stream(stack).sum();
    }
}