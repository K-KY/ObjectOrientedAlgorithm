import java.util.*;
import java.io.*;

public class Main {
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));;
    int[] fsCs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int frameSize = fsCs[0];
    int cmdSize = fsCs[1];
    int[][] frame = new int[frameSize +1][frameSize +1];
    for (int i = 1; i <= frameSize; i++) {
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int j = 1; j <= frameSize; j++) {
            if (j == 1) {
                frame[i][j] = array[j - 1];
                continue;
            }
            frame[i][j] = frame[i][j - 1] + array[j - 1];

        }
    }

    for (int i = 1; i <= frameSize; i++) {
        for (int j = 1; j <= frameSize; j++) {
            frame[i][j] += frame[i - 1][j];
        }
    }

    for (int i = 0; i < cmdSize; i++) {
        int[] sXYeXY = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sX = sXYeXY[0];
        int sY = sXYeXY[1];
        int eX = sXYeXY[2];
        int eY = sXYeXY[3];

        int result = frame[eX][eY] - frame[sX - 1][eY] - frame[eX][sY - 1] + frame[sX - 1][sY - 1];
        bw.write(result+"\n");
    }
    bw.flush();
}
}
//