import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(n -> (int) Math.pow(Integer.parseInt(n), 2)).toArray();
            
            Arrays.sort(arr);
            
            if (arr[0] + arr[1] + arr[2] == 0) {
                return;
            }
            if (arr[0] + arr[1] == arr[2]) {
                System.out.println("right");
                continue;
            }
            System.out.println("wrong");

        }
    }
}