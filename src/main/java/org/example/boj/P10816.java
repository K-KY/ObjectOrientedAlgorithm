package org.example.boj;


import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/*
문제
숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다.
정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다.
둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다. 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.

셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다.
넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수가 주어지며, 이 수는 공백으로 구분되어져 있다.
이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.

출력
첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력한다.

*/
public class P10816 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = in.nextInt();
        }
        Arrays.sort(cards);


        int h = in.nextInt();
        int[] have = new int[h];
        for (int i = 0; i < h; i++) {
            have[i] = in.nextInt();
        }


        StringJoiner sj = new StringJoiner(" ");
        for (int has : have) {
            int bsl = binarySearchLeft(cards, has);
            int bsr = binarySearchRight(cards, has);

            sj.add(bsr - bsl + "");
        }

        System.out.println(sj);


    }

    //-10 - 10 2 3 3 6 7 10 10 10
    //3 m = 4 l = 0 h = len
    //10 l = 5 h = len m = 6
    //l = 5 h = 5
    public static int binarySearchLeft(int[] cards, int target) {
        int low = 0;
        int high = cards.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (cards[mid] >= target) {
                high = mid;
            }

            if (cards[mid] < target) {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int binarySearchRight(int[] cards, int target) {
        int low = 0;
        int high = cards.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (cards[mid] > target) {
                high = mid;
            }

            if (cards[mid] <= target) {
                low = mid + 1;
            }
        }
        return low;
    }

    //왼쪽의 인덱스
    public static int left(int[] cards, int target, int index) {
        int left = 0;
        while (cards[index] == target) {
            left++;
            index--;
            if (index < 0) {
                break;
            }
        }
        return left;
    }

    //오른쪽의 인덱스
    public static int right(int[] cards, int target, int index) {
        int right = 0;
        while (cards[index] == target) {
            right++;
            index++;
            if (index == cards.length) {
                break;
            }
        }
        return right;
    }
}
