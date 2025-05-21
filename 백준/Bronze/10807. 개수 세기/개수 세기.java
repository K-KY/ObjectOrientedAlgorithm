import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = Integer.parseInt(sc.nextLine());
        int[] arr = List.of(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(sc.nextLine());
        Arrays.sort(arr);
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] == target) {
        		ans++;
        	}
        	if (arr[i] > target) {
        		break;
        	}
        }
        
        System.out.println(ans);
    }
}