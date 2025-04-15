import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringJoiner sj = new StringJoiner("\n");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int target = sc.nextInt();
            for (int j = 2; j <= 64; j++) {
                if (isSymmetrical(convert(target, j))) {
                    sj.add("1");
                    break;
                }
                if (j == 64 && !isSymmetrical(convert(target, j))) {
                    sj.add("0");
                }
            }
        }
        System.out.println(sj);
    }

    public static List<Integer> convert(int number, int radix) {
        List<Integer> numbers = new ArrayList<>();
        while (number > 0) {
            numbers.add(number % radix);
            number /= radix;
        }
        return numbers;
    }

    public static boolean isSymmetrical(List<Integer> numbers) {
        int start = 0;
        int end = numbers.size() - 1;
        while (start <= end) {
            int s = numbers.get(start);
            int e = numbers.get(end);
            if (s != e) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}