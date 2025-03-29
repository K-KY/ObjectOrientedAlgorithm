import java.io.*;
//개미의 기울기 절대값은 1
//즉 움직인 시간만큼 x y 좌표가 변화한다.
//6 4
//4 1
//8
//이경우 움직인 절대값만 봤을 때
//최종 위치는 12 , 9
//프레임의 x최대값은 6이니까 6으로 나눈 나머지 값이 개미의 최종 x좌표,
//프레임의 y최대값은 4니까 4로 나눈 나머지 값이 개미의 최종 y좌표
//개미의 좌표는 0, 1

public class Main {
    public static void main(String[] args) throws IOException {
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String[] frames = in.readLine().split(" ");
    String[] antXY = in.readLine().split(" ");
    int time = Integer.parseInt(in.readLine());

    int x = (Integer.parseInt(antXY[0]) + time) % (2 * Integer.parseInt(frames[0]));
    int y = (Integer.parseInt(antXY[1]) + time) % (2 * Integer.parseInt(frames[1]));

    if (x > Integer.parseInt(frames[0])) {
        x = 2 * Integer.parseInt(frames[0]) - x;
    }

    if (y > Integer.parseInt(frames[1])) {
        y = 2 * Integer.parseInt(frames[1]) - y;
    }

    out.write( Math.abs(x) + " " + Math.abs(y));
    out.flush();
    }
}