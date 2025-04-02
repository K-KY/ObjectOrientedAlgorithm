import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] condition = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < condition[0]; i++) {
            int[] arr = new int[condition[1]];
            for (int j = 0; j < condition[1]; j++) {
                arr[j] = sc.nextInt();
            }
            result.add(arr);
        }
        for (int i = 0; i < condition[0]; i++) {
            int[] arr = new int[condition[1]];
            for (int j = 0; j < condition[1]; j++) {
                arr[j] = sc.nextInt();
                result.get(i)[j] += arr[j];
            }
        }

        result.stream().map(arr -> {
            StringJoiner stringJoiner = new StringJoiner(" ");
            Arrays.stream(arr).boxed().map(String::valueOf).forEach(stringJoiner::add);
            return stringJoiner.toString();
        }).forEach(System.out::println);
    }
}
