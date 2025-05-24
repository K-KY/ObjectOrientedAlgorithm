import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
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

    //-10 -10 2 3 3 6 7 10 10 10
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
