
import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/*1 X: 정수 X를 덱의 앞에 넣는다. (1 ≤ X ≤ 100,000)
2 X: 정수 X를 덱의 뒤에 넣는다. (1 ≤ X ≤ 100,000)
3: 덱에 정수가 있다면 맨 앞의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
4: 덱에 정수가 있다면 맨 뒤의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
5: 덱에 들어있는 정수의 개수를 출력한다.
6: 덱이 비어있으면 1, 아니면 0을 출력한다.
7: 덱에 정수가 있다면 맨 앞의 정수를 출력한다. 없다면 -1을 대신 출력한다.
8: 덱에 정수가 있다면 맨 뒤의 정수를 출력한다. 없다면 -1을 대신 출력한다.
*/

public class Main {
    public static void main(String[] args) throws Exception {
        Deque<Integer> stack = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
        int len = Integer.parseInt(sc.nextLine());

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int[] cmd = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            stringBuilder.append(proceed(stack, cmd));
        }

        System.out.println(stringBuilder);

    }

    public static String proceed(Deque<Integer> stack, int[] cmd) {
        if (cmd[0] == 1) {
            stack.push(cmd[1]);
            return "";
        }
        if (cmd[0] == 2) {
            stack.offerLast(cmd[1]);
            return "";
        }
        if (cmd[0] == 3) {
            if (stack.isEmpty()) {
                return "-1"+"\n";
            }
            return stack.pollFirst() + "\n";
        }
        if (cmd[0] == 4) {
            if (stack.isEmpty()) {
                return "-1"+"\n";
            }
            return stack.pollLast() + "\n";
        }
        if (cmd[0] == 5) {
            return stack.size() + "\n";
        }
        if (cmd[0] == 6) {
            if (stack.isEmpty()) {
                return "1"+"\n";
            }
            return "0"+"\n";
        }
        if (cmd[0] == 7) {
            if (stack.isEmpty()) {
                return "-1"+"\n";
            }
            return stack.peek() + "\n";
        }
        if (cmd[0] == 8) {
            if (stack.isEmpty()) {
                return "-1"+"\n";
            }
            return stack.peekLast() + "\n";
        }
        return "-1"+"\n";
    }

}