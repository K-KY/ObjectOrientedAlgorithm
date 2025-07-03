import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] lenPrb = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        HashMap<Integer, String> dictNumber = new HashMap<>();
        HashMap<String, Integer> dictName = new HashMap<>();
        for (int i = 1; i < lenPrb[0] + 1; i++) {
            String name = sc.nextLine();
            dictNumber.put(i, name);
            dictName.put(name, i);
        }

        for (int i = 0; i < lenPrb[1]; i++) {
            String p = sc.nextLine().trim();
            if (isNumber(p)) {
                System.out.println(dictNumber.get(Integer.parseInt(p)));
                continue;
            }
            System.out.println(dictName.get(p));
        }
    }

    public static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}