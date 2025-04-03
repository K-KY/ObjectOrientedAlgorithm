package org.example.boj;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

/*
*
*
* 가로 길이가 w이고 세로 길이가 h인 2차원 격자 공간이 있다.
* 이 격자는 아래 그림처럼 왼쪽 아래가 (0,0)이고 오른쪽 위가 (w,h)이다. 이 공간 안의 좌표 (p,q)에 개미 한 마리가 놓여있다.
* 개미는 오른쪽 위 45도 방향으로 일정한 속력으로 움직이기 시작한다. 처음에 (p,q)에서 출발한 개미는 1시간 후에는 (p+1,q+1)로 옮겨간다.
* 단, 이 속력으로 움직이다가 경계면에 부딪치면 같은 속력으로 반사되어 움직인다.



위 그림은 6×4 격자에서 처음에 (4,1)에서 출발한 개미가 움직인 길을 보여주고 있다.
* 처음에 (4,1)에 있는 개미는 2시간 후에 (6,3)에 있으며 8시간 후에 (0,1)에 있다.
* 만일 그 개미가 처음에 (5,3)에 있었다면 매 시간마다 (6,4), (5,3), (4,2), (3,1)로 움직인다.

여러분은 크기 w×h인 격자 공간에서 처음에 (p,q)에서 출발하는 개미의 t시간 후의 위치 (x,y)를 계산하여 출력해야 한다.
* 개미는 절대 지치지 않고 같은 속력으로 이동한다고 가정한다.

문제에서 w와 h는 자연수이며 범위는 2 ≤ w,h ≤ 40,000이다. 그리고 개미의 초기 위치 p와 q도 자연수이며 범위는 각각 0 < p < w과 0 < q < h이다.
* 그리고 계산할 시간 t의 범위는 1 ≤ t ≤ 200,000,000이다.

*
* 개미가 최대로 움직일 수 있는 거리는 x와 y중 더 작은 값임
* 전체 프레임의 x 좌표 - 개미의 x 좌표
* 전처 프레임의 y 좌표 - 개미의 y 좌표
* 좌표가 0일 경우 이동 가능 좌표는 좌표의 최대값
* 이 둘중 더 작은 값이 개미가 이동할 수 있는 최대값
* 만약 연산자가 -인 경우 이동할 수 있는 최대값은 개미의 좌표만큼
* xOperand 와 yOperand 선언
* operand는 개미의 진행 방향을 나타낸다
* -일경우 좌표는 감소하는 방향 +일경우 좌표는 증가하는 방향으로
* x y 는 독립적인 연산자를 갖는다.
* -------
* 개미의 기울기 절대값은 1
* 즉 움직인 시간만큼 x y 좌표가 변화한다.
*
*
6 4
4 1
8
이경우 움직인 절대값만 봤을 때
* 최종 위치는 12 , 9
* 프레임의 x최대값은 6이니까 6으로 나눈 나머지 값이 개미의 최종 x좌표,
* 프레임의 y최대값은 4니까 4로 나눈 나머지 값이 개미의 최종 y좌표
* 개미의 좌표는 0, 1
*
*
*/
public class P10158 {
//    public static void main(String[] args) {
//        System.out.println(197 % 11);
//        System.out.println(197 / 11);
//        HashMap<String, Integer> map = new HashMap<>();
//        List<String> list = new ArrayList<>();
//        Scanner sc = new Scanner(System.in);
//        int[] frames = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        int[] antXY = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        int time = Integer.parseInt(sc.nextLine());
//        int xOperand = 1;
//        int yOperand = 1;
//
//        int availableX = 0;
//        int availableY = 0;
//        int movable = 0;
//        while (time > 0) {
//
//            availableX = getAvailableX(antXY[0], frames[0], xOperand);// 남은 x좌표 최대값
//            availableY = getAvailableY(antXY[1], frames[1], yOperand);// 남은 y좌표 최대값
//            movable = Math.min(availableX, availableY);// 움직일 수 있는 좌표 = x 남은값과, y남은 값중 작은값
//            movable = Math.min(time, movable);
//            System.out.println("time = " + time);
//            System.out.println("antX = " + antXY[0]);
//            System.out.println("antY = " + antXY[1]);
//            System.out.println("availableX = " + availableX);
//            System.out.println("availableY = " + availableY);
//
//            System.out.println("movable = " + movable);
//            System.out.println("movable * xOperand = " + movable * xOperand);
//            System.out.println("movable * yOperand = " + movable * yOperand);
//            System.out.println("xOperand = " + xOperand);
//            System.out.println("yOperand = " + yOperand);
//
//            antXY[0] += (movable * xOperand);// 개미 x좌표 이동
//            antXY[1] += (movable * yOperand);// 개미 y좌표 이동
//
//            xOperand = isXEnd(antXY, frames, xOperand);//x반대 방향으로 이동해야 하는지 확인
//            yOperand = isYEnd(antXY, frames, yOperand);//y 반대 방향으로 이동해야 하는지 확인
//
//
//            time -= movable;
//            map.put(antXY[0] + "+" + antXY[1], map.getOrDefault(antXY[0] + "+" + antXY[1], 0) + 1);
//            list.add(antXY[0] + "+" + antXY[1]);
//

    /// /            if (map.get(antXY[0] + "+" + antXY[1]) > 1) {
    /// /                break;
    /// /            }
//            if (movable * xOperand == 0 && movable * yOperand == 0) {
//                break;
//            }
//        }
//
//
//        System.out.println("antX = " + antXY[0]);
//        System.out.println("antY = " + antXY[1]);
//        System.out.println("map = " + map);
//        System.out.println("list = " + list);
//
//    }
//
//    private static int isXEnd(int[] antXY, int[] frames, int operand) {
//        if (antXY[0] == frames[0] || antXY[0] == 0) {
//            return operand *= -1;
//        }
//        return operand;
//    }
//
//    private static int isYEnd(int[] antXY, int[] frames, int operand) {
//        if (antXY[1] == frames[1] || antXY[1] == 0) {
//            System.out.println("antXY[1] = " + antXY[1]);
//            System.out.println("frames = " + frames[1]);
//            return operand *= -1;
//        }
//        return operand;
//    }
//
//    private static int getAvailableX(int antX, int framesX, int xOperand) {
//        if (xOperand == -1) {
//            return antX;
//        }
//        if (antX - framesX == 0) {
//            return framesX;
//        }
//        return Math.abs(antX - framesX);
//    }
//
//    private static int getAvailableY(int antY, int framesY, int yOperand) {
//        if (yOperand == -1) {
//            return antY;
//        }
//        if (antY - framesY == 0) {
//            return framesY;
//        }
//        return Math.abs(antY - framesY);
//    }
//
//
    public static void main(String[] args) throws IOException {
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String[] frames = in.readLine().split(" ");
    String[] antXY = in.readLine().split(" ");
    int time = Integer.parseInt(in.readLine());

    int x = (Integer.parseInt(antXY[0]) + time) % (2 * Integer.parseInt(frames[0]));
    int y = (Integer.parseInt(antXY[1]) + time) % (2 * Integer.parseInt(frames[1]));

    int i = Integer.parseInt(frames[0]) - (x - Integer.parseInt(antXY[0]));
    int j = Integer.parseInt(frames[1]) - (y - Integer.parseInt(antXY[1]));
    System.out.println("x = " + x);
    System.out.println("y = " + y);
    if (x > Integer.parseInt(frames[0])) {
        x = 2 * Integer.parseInt(frames[0]) - x;
    }
    System.out.println("x = " + x);

    if (y > Integer.parseInt(frames[1])) {
        y = 2 * Integer.parseInt(frames[1]) - y;
    }
    System.out.println("y = " + y);

    out.write( Math.abs(x) + " " + Math.abs(y));
    out.flush();

//        Scanner sc = new Scanner(System.in);
//        int w = sc.nextInt();
//        int h = sc.nextInt();
//
//        int x = sc.nextInt();
//        int y = sc.nextInt();
//
//        int t = sc.nextInt();
//
//        x = (w - x) < (t - w) ? Math.abs((t - w) - (w - x)) : Math.abs((w - x) - (t - w));
//        y = (h - y) < (t - h) ? Math.abs((t - h) - (h - y)) : Math.abs((h - y) - (t - h));
//
//        System.out.println(x + " " + y);


    }
}


/*
*
*
*
3500 3500
5 2
2000000
*
*
*
6 4
0 0

*
*원래 자리에서 4칸 더 이동, 상한 값 4최종값 7 - 진행 3 결과 3
* */