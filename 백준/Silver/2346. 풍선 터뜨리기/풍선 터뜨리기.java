
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Deque<Numbers> stack = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
        StringJoiner sj = new StringJoiner(" ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int e = sc.nextInt();
            stack.offerLast(new Numbers(e, i + 1));
        }
        Numbers pop = stack.pop();
        sj.add("" + pop.seq);

        while (!stack.isEmpty()) {
            if (pop.number > 0) {
                for (int i = 0; i < pop.number - 1; i++) {
                    stack.offerLast(stack.pollFirst());
                }
                pop = stack.pollFirst();
                sj.add("" + Objects.requireNonNull(pop).seq);
                continue;
            }
            if (pop.number < 0) {
                for (int i = 0; i < Math.abs(pop.number) - 1; i++) {
                    stack.offerFirst(stack.pollLast());
                }
                pop = stack.pollLast();
                sj.add("" + Objects.requireNonNull(pop).seq);
                continue;
            }
        }

        System.out.println(sj);


    }
}

class Numbers {
    int number;
    int seq;

    public Numbers(int number, int seq) {
        this.number = number;
        this.seq = seq;
    }

    public int getNumber() {
        return number;
    }

    public int getSeq() {
        return seq;
    }
}
