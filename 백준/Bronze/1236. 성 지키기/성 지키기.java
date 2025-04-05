import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] vertical = new int [input[0]];
        int[] horizontal = new int [input[1]];
        for (int i = 0; i < vertical.length; i++) {
            String line = sc.nextLine();
            if (line.contains("X")) {
                vertical[i] = 1;
            }
            for (int j = 0; j < horizontal.length; j++) {
                if (line.charAt(j) == 'X') {
                    horizontal[j] = 1;
                }
            }
        }

        int hSum = Arrays.stream(horizontal).filter(t -> t == 0).toArray().length;
        int vSum = Arrays.stream(vertical).filter(v -> v == 0).toArray().length;
        System.out.println(Math.max(hSum, vSum));
        
    }
}
