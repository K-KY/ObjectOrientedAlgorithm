//시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        
        if (a >= 90) {
            System.out.println("A");
            return;
        }
        
        if (a < 90 && a >= 80) {
            System.out.println("B");
            return;
        }
        
        if (a < 80 && a >= 70) {
            System.out.println("C");
            return;
        }
        
        if (a < 70 && a >= 60) {
            System.out.println("D");
            return;
        }
        
        System.out.println("F");
    }
}