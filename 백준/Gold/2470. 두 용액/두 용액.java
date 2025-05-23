import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        Arrays.sort(arr);

        for (int j = 0; j < arr.length; j++) {
            int bs = binarySearch(arr, arr[j], j + 1);
            if (Math.abs(arr[bs] + arr[j]) < min) {
                min = Math.abs(arr[bs] + arr[j]);
                left = arr[j];
                right = arr[bs];
            }
        }


        if (left > right) {
            System.out.print(right + " " + left);
            return;
        }

        if (left < right) {
            System.out.print(left + " " + right);
            return;
        }
        System.out.print(left + " " + right);

    }

    public static int binarySearch(int[] arr, int n, int low) {
        //arr[i] + n 이 Abs(min)보다 작으면 교체
        //arr[i] + n 이 0보다 작으면 low = mid + 1
        //arr[i] + n 이 0보다 크면 high = mid - 1
        int high = arr.length - 1;
        int min = Integer.MAX_VALUE;
        int index = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] + n == 0) {
                return mid;
            }

            if (arr[mid] + n < 0 && arr[mid] != n) {
                if (Math.abs(min) > Math.abs(arr[mid] + n)) {
                    min = Math.abs(arr[mid] + n);
                    index = mid;
                }
                low = mid + 1;

            }

            if (arr[mid] + n > 0 && arr[mid] != n) {
                if (Math.abs(min) > Math.abs(arr[mid] + n)) {
                    min = Math.abs(arr[mid] + n);
                    index = mid;
                }

                high = mid - 1;
            }



        }


        return index;

    }
}