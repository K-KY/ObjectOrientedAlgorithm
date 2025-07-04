import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int len = Integer.parseInt(reader.readLine());
        for (int i = 0; i < len; i++) {
            String cmd = reader.readLine();
            sb.append(procedure(cmd, stack));
        }
        writer.write(sb.toString());
        writer.flush();
        writer.close();

    }

    public static String procedure(String cmd, Stack<Integer> stack) {
            String[] seperate = seperate(cmd);
            return proceed(seperate, stack);
    }

    public static String proceed(String[] cmd, Stack<Integer> stack) {
        if (Objects.equals(cmd[0], "1")) {
            stack.push(Integer.parseInt(cmd[1]));
            return "";
        }
        if (Objects.equals(cmd[0], "2")){
            if (stack.isEmpty()) {
                return -1+"\n";
            }
            Integer pop = stack.pop();
            return pop+"\n";
        }

        if (Objects.equals(cmd[0], "3")){
            return stack.size()+"\n";
        }

        if (Objects.equals(cmd[0], "4")){
            return stack.size() == 0 ? 1+"\n" : 0+"\n";
        }
        if (Objects.equals(cmd[0], "5")){
            int size = stack.size();
            return size == 0 ? -1+"\n" : stack.peek()+"\n";
        }
        throw new IllegalArgumentException();
    }


    private static String[] seperate(String cmd) {
        return cmd.split(" ");
    }

}

class CustomStack<T> {
    private T[] stack;
    private int peek = -1;
    private int capacity = 10;
    @SuppressWarnings("unchecked")
    public CustomStack() {
        stack = (T[]) new Object[10];
    }

    public T push(T element) {
        if (peek + 1 >= stack.length) {
            grow(capacity);
        }
        stack[++peek] = element;
        return element;
    }

    public void grow(int capacity) {
        stack = Arrays.copyOf(stack, peek + capacity * 2);
    }

    //스택의 맨 위의 요소를 제거하고 반환
    public T pop() {
        if (peek > -1) {
            T t = stack[peek];
            stack[peek--] = null;
            return t;
        }
        return null;
    }

    public T peek() {
        if (peek > -1) {
            return stack[peek];
        }
        return null;
    }

    //스택의 크기 반환
    public int size() {
        return peek + 1;
    }

    @Override
    public String toString() {
        return Arrays.toString(stack);
    }
}