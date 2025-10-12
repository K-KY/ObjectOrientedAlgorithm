import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Set<Integer>> nodes = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());// 노드 개수
        int m = Integer.parseInt(st.nextToken());// 간선 개수
        int r = Integer.parseInt(st.nextToken());// 시작 노드
        int t = 0;
        int[] visited = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            visited[i] = -1;
        }
        for (int i = 0; i <= n; i++) { //1-base 니까 0번을 제외한 n개
            nodes.add(new TreeSet<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes.get(a).add(b);
            nodes.get(b).add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);

        while (!queue.isEmpty()) {
            List<Integer> process = new ArrayList<>();
            int flag = 0;
            while (!queue.isEmpty()) {
                process.add(queue.poll());
            }

            for (int i = 0; i < process.size(); i++) {
                Integer p = process.get(i);
                if (visited[p] != -1) {
                    continue;
                }

                visited[p] = t;
                queue.addAll(nodes.get(p));
                flag = 1;
            }
            if (flag != 0) {
                t++;
            }

        }

        for (int i = 1; i < visited.length; i++) {
            bw.write(visited[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();


    }

}
