import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        QQQ customQueue= new QQQ();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] arr = reader.readLine().split(" ");
            if (arr[0].equals("front")) {
                sb.append(customQueue.front()).append("\n");
            }
            if (arr[0].equals("back")) {
                sb.append(customQueue.back()).append("\n");
            }
            if (arr[0].equals("push")) {
                customQueue.push(Integer.parseInt(arr[1]));
            }
            if (arr[0].equals("size")) {
                sb.append(customQueue.size()).append("\n");
            }
            if (arr[0].equals("pop")) {
                sb.append(customQueue.pop()).append("\n");
            }
            if (arr[0].equals("empty")) {
                sb.append(customQueue.isEmpty()).append("\n");
            }
        }
        writer.write(sb.toString());
        writer.flush();
    }
}

class QQQ {
    Queue<Integer> queue;
    int last;

    public QQQ() {
        queue = new LinkedList<>();
        last = Integer.MIN_VALUE;
    }

    public void push(int val) {
        queue.add(val);
        last = val;
    }

    public int pop() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.poll();
    }

    public int front() {
        int size = queue.size();
        if (size == 0) {
            return -1;
        }
        return queue.peek();
    }

    public int back() {
        if (queue.isEmpty()) {
            return -1;
        }
        return last;
    }

    public int size() {
        return queue.size();
    }

    public int isEmpty() {
        return queue.isEmpty() ? 1 : 0;
    }
}
