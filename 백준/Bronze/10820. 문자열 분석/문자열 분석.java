import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int upper;
        int lower;
        int digit;
        int blank;
        while (in.hasNext()) {
            upper = lower = digit = blank = 0;
            String s = in.nextLine();
            for (int i = 0; i < s.length(); i++) {
                String substring = s.substring(i, i + 1);
                if (isUpper(substring)) {
                    upper++;
                    continue;
                }
                if (isLower(substring)) {
                    lower++;
                    continue;
                }
                if (isDigit(substring)) {
                    digit++;
                    continue;
                }
                if (isBlank(substring)) {
                    blank++;
                    continue;
                }
            }

            System.out.println(lower + " " + upper + " " + digit + " " + blank);

        }
    }

    public static boolean isUpper(String s) {
        return s.charAt(0) >= 'A' && s.charAt(0) <= 'Z';
    }
    public static boolean isLower(String s) {
        return s.charAt(0) >= 'a' && s.charAt(0) <= 'z';
    }
    public static boolean isDigit(String s) {
        return s.charAt(0) >= '0' && s.charAt(0) <= '9';
    }
    public static boolean isBlank(String s) {
        return s.trim().isEmpty();
    }
}
