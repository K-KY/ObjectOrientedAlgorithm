import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] nmr = br.readLine().split(" ");
        int n = Integer.parseInt(nmr[0]); // 노드 개수
        int m = Integer.parseInt(nmr[1]); // 간선 개수
        int r = Integer.parseInt(nmr[2]); // 시작 노드

        int[] visited = new int[n + 1]; // 1-based 라서 +1 해서 1부터 5까지 5개 0 포함 6개의 배열
        int t = 1;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        br.close();

        graph.forEach(q -> q.sort(Comparator.reverseOrder()));



//        System.out.println("graph = " + graph);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            if (visited[poll] != 0) {
                continue;
            }
            visited[poll] = t++;
            List<Integer> node = graph.get(poll);
            queue.addAll(node);
        }

        for (int i = 1; i < visited.length; i++) {
            bw.write(visited[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
