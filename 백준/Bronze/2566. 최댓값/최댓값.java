import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 0;
        int x = 0;
        int y = 0;
        for (int i = 1; i <= 9; i++) {
            int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            for (int j = 0; j < arr.length; j++) {
                int c = arr[j];
                if (c >= max) {
                    max = c;
                    x = i;
                    y = j + 1;
                }
            }
            
        }
        
        System.out.println(max);
        System.out.println(x + " " + y);
        
    }
}