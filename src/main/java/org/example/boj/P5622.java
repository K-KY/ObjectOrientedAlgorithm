package org.example.boj;

/*전화를 걸고 싶은 번호가 있다면, 숫자를 하나를 누른 다음에 금속 핀이 있는 곳 까지 시계방향으로 돌려야 한다. 숫자를 하나 누르면 다이얼이 처음 위치로 돌아가고, 다음 숫자를 누르려면 다이얼을 처음 위치에서 다시 돌려야 한다.

숫자 1을 걸려면 총 2초가 필요하다. 1보다 큰 수를 거는데 걸리는 시간은 이보다 더 걸리며, 한 칸 옆에 있는 숫자를 걸기 위해선 1초씩 더 걸린다.

상근이의 할머니는 전화 번호를 각 숫자에 해당하는 문자로 외운다. 즉, 어떤 단어를 걸 때, 각 알파벳에 해당하는 숫자를 걸면 된다. 예를 들어, UNUCIC는 868242와 같다.

할머니가 외운 단어가 주어졌을 때, 이 전화를 걸기 위해서 필요한 최소 시간을 구하는 프로그램을 작성하시오.

1 {}, 2 {A, B, C}. 3 {D, E, F} 4 {G, H, I} 5 {J, K, L} 6 {M, N, O}. 7 {P, Q, R, S} 8 {T, U, V} 9 {W, X, Y, Z}

A   B  C  D  E  F  G  H  I  J  K  L  M  N O  P  Q   R  S  T  U  V  W  X  Y  Z
65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90
n - 'A' = 0 ~ 2 -> 2
n - 'A' =  3 ~ 5 -> 3
n - 'A' = 6 ~ 8 -> 4

*/


import java.util.List;
import java.util.Scanner;

public class P5622 {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10};
        Scanner sc = new Scanner(System.in);
        int[] array = sc.nextLine().chars().toArray();
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += nums[array[i] - 'A'] ;
        }

        System.out.println(sum);
    }
}
