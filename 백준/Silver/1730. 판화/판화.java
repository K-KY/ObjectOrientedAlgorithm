import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static final String horizonMoving = "-";
    private static final String verticalMoving = "|";
    private static final String cross = "+";
    private static final String unknown = ".";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[][] frame = new String[n][n];
        String[] commands = sc.nextLine().split("");
        int rx = 0;
        int ry = 0;
        for (int i = 0; i < commands.length; i++) {
            String current = frame[ry][rx];
            String command = commands[i];

            if (rx < n - 1 && command.equals("R")) {
                frame[ry][rx] = getCommand(command, current);
                ++rx;
                frame[ry][rx] = getCommand(command, frame[ry][rx]);
            }
            if (rx > 0 && command.equals("L")) {
                frame[ry][rx] = getCommand(command, current);
                --rx;
                frame[ry][rx] = getCommand(command, frame[ry][rx]);
            }
            if (ry < n - 1 && command.equals("D")) {
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
