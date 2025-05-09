import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입력/출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 입력 행렬 및 누적합 배열 (1-based indexing)
        int[][] matrix = new int[N + 1][N + 1];
        int[][] prefix = new int[N + 1][N + 1];

        // 표 입력 받기
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                // 누적합 계산
                prefix[i][j] = matrix[i][j]
                             + prefix[i - 1][j]
                             + prefix[i][j - 1]
                             - prefix[i - 1][j - 1];
            }
        }

        // 질의 처리
        for (int q = 0; q < M; q++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = prefix[x2][y2]
                    - prefix[x1 - 1][y2]
                    - prefix[x2][y1 - 1]
                    + prefix[x1 - 1][y1 - 1];

            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
