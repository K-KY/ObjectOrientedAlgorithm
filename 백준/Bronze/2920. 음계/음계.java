import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(isASCSorted(arr));
        
   }
    public static String isASCSorted(int[] arr) {
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < prev) {
                return isDESCSorted(arr);
            }
            prev = arr[i];
        }
        return "ascending";
    }
    
    public static String isDESCSorted(int[] arr) {
        int prev = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > prev) {
                return "mixed";
            }
            prev = arr[i];
        }
        return "descending";
    }    
}