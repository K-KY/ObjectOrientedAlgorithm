package org.example.boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/*
*가로, 세로의 크기가 각각 100인 정사각형 모양의 흰색 도화지가 있다.
* 이 도화지 위에 가로, 세로의 크기가 각각 10인 정사각형 모양의 검은색 색종이를 색종이의 변과 도화지의 변이 평행하도록 붙인다.
*  이러한 방식으로 색종이를 한 장 또는 여러 장 붙인 후 색종이가 붙은 검은 영역의 넓이를 구하는 프로그램을 작성하시오.
*
* 예를 들어 흰색 도화지 위에 세 장의 검은색 색종이를 그림과 같은 모양으로 붙였다면 검은색 영역의 넓이는 260이 된다.

3
3 7
15 7
5 2

* 두 좌표를 뺀 x y 좌표가 둘 다 10 이하인 값이 겹치는 좌표임
* 둘 중 하나라도 10 이상이라면 색종이는 안겹침
* 3 - 15 = 12, 7 - 7 = 0, -> x y = 12, 0
* 1번쨰와 2번째의 경우 y좌표가 같지만 x 좌표가 서로 2만큼 떨어져있음 -> 색종이 크기 - 뺀 값 = 2
* 3 - 5 = 2. 7 - 2 = 5 -> x y = 2, 5
* x = 10 - 2 = 8, y = 10 - 5, x y = 8, 5 색종이는 x좌표 8만큼, y좌표 5만큼 겹쳐있다
* 8*5 = 40,  색종이의 총 개수 * 100 에서 겹치는 만큼 계속 차감
 *
*
* */
public class P2563 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        List<Tile> tiles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            tiles.add(new Tile(input[0], input[1], i));
        }

        for (int i = 0; i < tiles.size() - 1; i++) {
            for (int j = i + 1; j < tiles.size(); j++) {
                int layered = tiles.get(i).layered(tiles.get(j));
                sum += layered;
                if (layered == 100) {
                    break;
                }

            }
        }

        System.out.println((n * 100) - sum);
    }
}

class Tile {
    protected final int x;
    protected final int y;
    private final int number;
    private final List<Integer> calculated = new ArrayList<>();
    public Tile(String x, String y, int number) {
        this.x = Integer.parseInt(x);
        this.y = Integer.parseInt(y);
        this.number = number;
    }

    public int layered(Tile tile) {
        int layerX = Math.abs(tile.x - this.x);
        int layerY = Math.abs(tile.y - this.y);
        if (layerX >= 10 || layerY >= 10 || equals(tile) || this.calculated.contains(tile.number) || tile.calculated.contains(this.number)) {
            return layeredRange(0, 0);
        }
        tile.calculated.add(this.number);
        this.calculated.add(tile.number);
        System.out.println("calculated = " + calculated);
        return layeredRange((10 - layerX), (10 - layerY));
    }

    private int layeredRange(int layerX, int layerY) {
        int i = layerX * layerY;
        System.out.println("layerX = " + layerX);
        System.out.println("layerY = " + layerY);
        System.out.println("i = " + i);
        return i;
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return x == tile.x && y == tile.y && number == tile.number;
    }

    public int hashCode() {
        return Objects.hash(x, y, number);
    }
}


/*
*
4
3 7
15 7
5 2
14 2
4
3 7
15 7
5 2
15 2
*/