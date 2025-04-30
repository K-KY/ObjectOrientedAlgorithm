import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        List<String> members = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] member = reader.readLine().split(" ");
            if (member[1].equals("leave")) {
                map.put(member[0], 0);
                continue;
            }
            map.put(member[0], 1);
//            members.add(member[0]);
        }
        map.forEach((k, v) -> {
            if (v == 1) {
                members.add(k);
            }
        });

//        members.sort(Comparator.reverseOrder());
        sort(members, 0, members.size() - 1);
        for (String member : members) {
            writer.write(member);
            writer.newLine();
        }
        writer.flush();
    }

    public static void sort(List<String> members, int low, int high) {
        if (low <= high) {
            int partition = partition(members, low, high);
            sort(members, low, partition - 1);
            sort(members, partition + 1, high);
        }
    }

    public static int partition(List<String> members, int low, int high) {
        String pivot = members.get(high);
        int l = low - 1;
        for (int i = low; i < high; i++) {
            if (compare(pivot, members.get(i)) < 0) {
                l++;
                swap(members, l, i);
            }
        }
        swap(members, l + 1, high);
        return l + 1;
    }

    public static int compare(String m1, String m2) {
        return m1.compareTo(m2);
    }

    public static void swap(List<String> members, int i, int j) {
        String temp = members.get(j);
        members.set(j, members.get(i));
        members.set(i, temp);
    }
}
