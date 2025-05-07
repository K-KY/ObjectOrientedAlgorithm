import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int frameSize = sc.nextInt();
        int cmdSize = sc.nextInt();
        int[][] frame = new int[frameSize +1][frameSize +1];
        for (int i = 1; i <= frameSize; i++) {
            for (int j = 1; j <= frameSize; j++) {
                if (j == 1) {
                    frame[i][j] = sc.nextInt();
                    continue;
                }
                frame[i][j] = frame[i][j - 1] + sc.nextInt();

            }
        }

        for (int i = 1; i <= frameSize; i++) {
            for (int j = 1; j <= frameSize; j++) {
                frame[i][j] += frame[i - 1][j];
            }
        }

        for (int i = 0; i < cmdSize; i++) {
            int sX = sc.nextInt();
            int sY = sc.nextInt();
            int eX = sc.nextInt();
            int eY = sc.nextInt();

            int result = frame[eX][eY] - frame[sX - 1][eY] - frame[eX][sY - 1] + frame[sX - 1][sY - 1];
            System.out.println(result);
        }
    }
}
//