import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Map<Integer, TreeSet<Integer>> bfs = new HashMap<>();
        String[] nmr = br.readLine().split(" ");

        int n = Integer.parseInt(nmr[0]); //노드의 수
        int m = Integer.parseInt(nmr[1]); //간선 개수
        int r = Integer.parseInt(nmr[2]); //시작 노드
        int[] visited = new int[n + 1];

        int t = 1;

        for (int i = 0; i <= n; i++) {
            bfs.put(i, new TreeSet<>());
        }

        for (int i = 0; i < m; i++) {
            String[] ab = br.readLine().split(" ");

            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            //무방향 이므로 두 숫자 모두 넣음
            bfs.get(a).add(b);
            bfs.get(b).add(a);
        }

        br.close();


//        System.out.println("bfs = " + bfs);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);//시작 노드 큐에 넣기

        bfs(queue, visited, t, bfs);

        for (int i = 1; i < visited.length; i++) {
            bw.write(visited[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void bfs(Queue<Integer> queue, int[] visited, int t, Map<Integer, TreeSet<Integer>> bfs) {
        while (!queue.isEmpty()) {
            int poll = queue.poll();//큐에서 꺼내기
//            System.out.println("poll = " + poll);
            if (visited[poll] == 0) {//꺼낸게 방문되지 않은 노드면
                visited[poll] = t++;// 방문한 노드 방문 처리, 순서 증가
                TreeSet<Integer> integers = bfs.get(poll);
                queue.addAll(integers);
//                System.out.println("queue = " + queue);
            }
        }
    }
}