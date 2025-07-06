import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        IntStream.range(1, n + 1).forEach(queue::add);

        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }

        System.out.println(queue.poll());
    }

}