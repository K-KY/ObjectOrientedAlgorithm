import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> temp = new LinkedList<>();
        StringJoiner sj = new StringJoiner(", ", "<", ">");
        int len = sc.nextInt();
        int n = sc.nextInt();

        IntStream.range(1, len + 1).forEach(queue::add);

        while (!queue.isEmpty()) {

            //큐에 넣기
            for (int i = 0; i < n; i++) {
                if (!queue.isEmpty()) {
                    temp.add(queue.poll());
                }
            }

            //n번째 값을 제외하고 큐에 다시 넣기
            for (int i = 0; i < n - 1; i++) {
                if (!temp.isEmpty()) {
                    queue.add(temp.poll());
                }

                if (temp.isEmpty()) {
                    for (int j = i; j < n; j++) {
                        temp.add(queue.poll());
                        if (queue.isEmpty()) {
                            break;
                        }
                    }
                }
            }
            sj.add(temp.poll() + "");
        }

        if (!temp.isEmpty()) {
            sj.add(temp.poll() + "");
        }

        System.out.println(sj);

    }
}