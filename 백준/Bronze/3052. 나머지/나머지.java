import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        List<Integer> arr = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            int a = sc.nextInt();
            
            if (!arr.contains(a%42)) {
                   arr.add(a%42);
            }
        }
        
        System.out.println(arr.size());
    }
}