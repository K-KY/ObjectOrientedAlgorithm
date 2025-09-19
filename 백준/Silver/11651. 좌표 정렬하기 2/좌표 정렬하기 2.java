import java.util.*;

/*
* 2차원 평면 위의 점 N개가 주어진다.
* 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

입력
*
* 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다.
* 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다.
* (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.

5
0 4
1 2
1 -1
2 2
3 3
*
* 1 -1
1 2
2 2
3 3
0 4
*/
public class Main {
    public static void main(String[] args) {
        Comparator<Pair> comparator = Comparator.comparingInt(Pair::getY).thenComparingInt(Pair::getX);
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            pairs.add(new Pair(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
        }

        pairs.sort(comparator);
        pairs.forEach(pair -> System.out.println(pair.getX() + " " + pair.getY()));

    }

    static class Pair {
        final int x;
        final int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
