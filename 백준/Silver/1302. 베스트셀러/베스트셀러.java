import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, Integer> books = new HashMap<>();
        List<String> bestSellers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String key = sc.nextLine();
            books.put(key, books.getOrDefault(key, 0) + 1);
        }
        int max = books.values().stream().max(Integer::compareTo).orElse(0);

        books.forEach((k, v) -> {
            if (v == max) {
                bestSellers.add(k);
            }
        });

        if (bestSellers.size() == 1) {
            System.out.println(bestSellers.get(0));
            return;
        }
        sort(bestSellers, 0, bestSellers.size() - 1);
        System.out.println(bestSellers.get(0));
    }

    public static void sort(List<String> books, int low, int high) {
        if (low <= high) {
            int partition = partition(books, low, high);
            sort(books, low, partition - 1);
            sort(books, partition + 1, high);
        }
    }

    public static int partition(List<String> books, int low, int high) {
        String pivot = books.get(high);
        int l = low - 1;
        for (int i = low; i < high; i++) {
            if (books.get(i).compareTo(pivot) < 0) {
                l++;
                swap(books, l, i);
            }
        }
        swap(books, l + 1, high);
        return l + 1;
    }
    public static void swap(List<String> books, int i, int j) {
        String temp = books.get(i);
        books.set(i, books.get(j));
        books.set(j, temp);
    }
}
