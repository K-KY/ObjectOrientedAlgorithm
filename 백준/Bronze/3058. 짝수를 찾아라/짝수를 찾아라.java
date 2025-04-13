import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int min ;
        int sum;
        for (int i = 0; i < n; i++) {
            min = Integer.MAX_VALUE;
            sum = 0;
            int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] % 2 == 0) {
                    sum += arr[j];
                    min = Math.min(arr[j], min);
                }
            }
            System.out.println(sum + " " + min);
        }
    }
}
