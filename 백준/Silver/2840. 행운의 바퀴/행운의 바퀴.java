import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        Circular circular = new Circular(n);

        for (int i = 0; i < k; i++) {
            boolean check = circular.positionShift(in.nextInt(), in.next());
            if (!check) {
                System.out.println("!");
                return;
            }
        }
        System.out.println(circular.printCurrentCircular());
    }
}

class Circular {
    private final String[] items;
    private int currentPosition = 0;

    public Circular(int n) {
        items = new String[n];
    }

    public boolean positionShift(int n, String item) {
        int nextPosition = currentPosition + n;
        if (nextPosition >= items.length) {
            nextPosition %= items.length;
        }
        if (items[nextPosition] != null && !items[nextPosition].equals(item)) {
            return false;
        }
        if (Arrays.asList(items).contains(item) && items[nextPosition] == null) {
            return false;
        }
        items[nextPosition] = item;
        currentPosition = nextPosition;
        return true;
    }

    public String printCurrentCircular() {
        StringBuilder sb = new StringBuilder();
        int pos = currentPosition;
        for (int i = 0; i < items.length; i++) {
            if (items[pos] != null) {
                sb.append(items[pos].trim());
            }
            if (items[pos] == null) {
                sb.append("?");
            }
            pos--;
            if (pos < 0) {
                pos = items.length - 1;
            }
        }
        return sb.toString();
    }
}
