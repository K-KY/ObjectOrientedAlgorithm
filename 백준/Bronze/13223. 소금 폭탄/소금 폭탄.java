import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] current = timeSeperator(sc.nextLine());
        int[] target = timeSeperator(sc.nextLine());

        int h = target[0]-current[0];
        int m = target[1]-current[1];
        int s = target[2]-current[2];

        if(s<0) {
            s+=60;
            m--;
        }
        if(m<0) {
            m+=60;
            h--;
        }
        if(h<0) {
            h+=24;
        }
        if(h==0 & m==0 & s==0) {
            h=24;
        }
        
        System.out.printf("%02d:%02d:%02d", h, m, s);
    }

    public static int[] timeSeperator(String times) {
        return Arrays.stream(times.split(":")).mapToInt(Integer::parseInt).toArray();
    }

}