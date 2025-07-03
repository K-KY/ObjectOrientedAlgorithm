package org.example.boj;

/*
W대학교 미술대학 조소과에서는 지루한 목판화 작업을 하는 학생들을 돕기 위해 판화 기계를 제작하였다.

기계는 로봇 팔이 쥔 조각도를 상하좌우 네 방향으로 움직일 수 있는 구조로서, 조각도 아래에 목판을 놓으면 그 위에 선들을 자동으로 그어주는 기능을 가지고 있다.

목판에는 N2개의 점들이 일정한 간격으로 N행 N열의 격자모양을 이루며 찍혀있다.
처음 로봇의 조각도를 올려놓는 위치는 항상 이 점들 중 맨 왼쪽 맨 위의 꼭짓점이다.

로봇 팔을 움직이는 명령의 순서가 주어졌을 때, 목판 위에 패인 조각도의 혼적을 출력하는 프로그램을 작성하시오.

판화 기계는 작동 도중 로봇 팔이 격자 바깥으로 나가도록 하는 움직임 명령을 만나면, 무시하고 그 다음 명령을 진행한다.

5
RRRRRRRRDDDDDDDD
DRDRRUU

2
RRDD
|..|.
++.|.
.+-+.
.....
.....

로봇의 현재 좌표를 기록
프레임은 스트링 2차원 배열
L -> 일 때 해당 좌표를 -로 변경, 이미 - 라면 아무것도 하지 않고 |라면 +로 변경
R -> 일 때 해당 좌표를 -로 변경, 이미 - 라면 아무것도 하지 않고 |라면 +로 변경
U -> 일 때 해당 좌표를 | 로 변경, 이미 | 라면 아무것도 하지 않고 - 라면 +로 변경
D -> 일 때 해당 좌표를 | 로 변경, 이미 | 라면 아무것도 하지 않고 - 라면 +로 변경

r 일 때 rx++ rx < n - 1
l 일 때 rx-- rx > 0
u 일 때 ry++ ry < n - 1
d 일 때 ry-- ry > 0

**/

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class P1730 {
    private static final String horizonMoving = "-";
    private static final String verticalMoving = "|";
    private static final String cross = "+";
    private static final String unknown = ".";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] frame = new String[n][n];
        String[] commands = sc.next().split("");
        int rx = 0;
        int ry = 0;
        for (int i = 0; i < commands.length; i++) {
            String current = frame[ry][rx];
            String command = commands[i];

            if (rx < n - 1 && command.equals("R")) {
                System.out.println("rx = " + rx);
                frame[ry][rx] = getCommand(command, current);
                ++rx;
                frame[ry][rx] = getCommand(command, frame[ry][rx]);
            }
            if (rx - 1 > 0 && command.equals("L")) {
                frame[ry][rx] = getCommand(command, current);
                --rx;
                frame[ry][rx] = getCommand(command, frame[ry][rx]);
            }
            if (ry < n - 1 && command.equals("D")) {
                System.out.println("ry = " + ry);
                frame[ry][rx] = getCommand(command, current);
                ++ry;
                frame[ry][rx] = getCommand(command, frame[ry][rx]);
            }
            if (ry > 0 && command.equals("U")) {
                frame[ry][rx] = getCommand(command, current);
                --ry;
                frame[ry][rx] = getCommand(command, frame[ry][rx]);
            }
//            if (current == null) {
//                frame[ry][rx] = getCommand(command, current);
//                continue;
//            }
//
//            current = frame[ry][rx];
//            String command1 = getCommand(command, current);
//            frame[ry][rx] = command1;
        }

        for (int i = 0; i < n; i++) {
            String[] strings = frame[i];
            Arrays.stream(strings).map(s -> Objects.requireNonNullElse(s, unknown)
            ).forEach(System.out::print);
            System.out.println();
        }

    }

    private static String getCommand(String command, String position) {
        if (position == null) {
            if (command.equals("R") || command.equals("L")) {
                return horizonMoving;
            }
            if (command.equals("U") || command.equals("D")) {
                return verticalMoving;
            }
        }
        if (command.equals("R") || command.equals("L")) {
            if (Objects.equals(horizonMoving, position)) {
                return horizonMoving;
            }
        }
        if (command.equals("U") || command.equals("D")) {
            if (Objects.equals(verticalMoving, position)) {
                return verticalMoving;
            }
        }
        return cross;
    }
}
