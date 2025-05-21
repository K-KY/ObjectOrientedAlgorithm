import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int ans = 0;
        String[] dict = new String[n];
        String[] targets = new String[m];

        for (int i = 0; i < n; i++) {
            dict[i] = in.next();
        }

        for (int i = 0; i < m; i++) {
            targets[i] = in.next();
        }

        if (dict.length < targets.length) {
            String[] temp = dict;
            dict = targets;
            targets = temp;
            m = n;
        }
        Arrays.sort(dict, String::compareTo);
        for (int i = 0; i < m; i++) {
            int s = binarySearch(dict, targets[i], 0, dict.length - 1);
            if (s == 0) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static int binarySearch(String[] dict, String target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (dict[mid].compareTo(target) > 0) {
                high = mid - 1;
            }

            if (dict[mid].compareTo(target) < 0) {
                low = mid + 1;
            }

            if (dict[mid].compareTo(target) == 0) {
                return 0;
            }
        }
        return -1;
    }
}
