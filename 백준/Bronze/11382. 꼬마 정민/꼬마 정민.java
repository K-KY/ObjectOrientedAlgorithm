import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        
        long answer = 0;
        
        for (int i = 0; i < arr.length; i++) {
            answer+=toInt(arr[i]);
        }
        
        System.out.println(answer);
    }
    
    static long toInt(String s) {
        return Long.parseLong(s);
    }
}