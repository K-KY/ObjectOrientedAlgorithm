import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Queue<String>> arr = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String s = in.nextLine();
            Queue<String> queue = new LinkedList<>(List.of(s.split("")));
            arr.add(queue);
        }

        while (!arr.isEmpty()) {
            arr = arr.stream().filter(a -> !a.isEmpty()).collect(Collectors.toList());
            for (Queue<String> queue : arr) {
                if (queue.peek() != null) {
                    String poll = queue.poll();
                    System.out.print(poll);
                }
            }
        }
    }
}