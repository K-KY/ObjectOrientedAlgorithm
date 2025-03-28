import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        Scanner sc = new Scanner(System.in);
        int[] currentTime = Arrays.stream(sc.nextLine().split(":")).mapToInt(Integer::parseInt).toArray();
        int[] setTime = Arrays.stream(sc.nextLine().split(":")).mapToInt(Integer::parseInt).toArray();


        LocalTime setLocalTime = LocalTime.of(setTime[0], setTime[1], setTime[2]);
        LocalTime currentLocalTime = LocalTime.of(currentTime[0], currentTime[1], currentTime[2]);
        String localTime;
        if (setLocalTime.equals(currentLocalTime)) {
            localTime = "24:00:00";
        } else {
            localTime = LocalTime.of(setTime[0], setTime[1], setTime[2])
                    .minusSeconds(currentTime[2])
                    .minusMinutes(currentTime[1])
                    .minusHours(currentTime[0]).format(formatter);
        }

        System.out.println(localTime.toString());
    }

}