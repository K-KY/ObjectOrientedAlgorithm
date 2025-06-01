/*같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.
같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.
*/
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int[] score = new int[7];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            score[arr[i]]++;
        }
        
        for (int i = 1; i < score.length; i++) {
            if (score[i] == 2) {
                System.out.println(1000 + (i * 100));
                return;
            }
            if (score[i] == 3) {
                System.out.println(10000 + (i * 1000));
                return;
            }
        }
        System.out.println(max * 100);

    }
}