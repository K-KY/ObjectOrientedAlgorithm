package org.example.boj;

import java.util.*;

/*
김형택은 탑문고의 직원이다. 김형택은 계산대에서 계산을 하는 직원이다.
김형택은 그날 근무가 끝난 후에, 오늘 판매한 책의 제목을 보면서 가장 많이 팔린 책의 제목을 칠판에 써놓는 일도 같이 하고 있다.

오늘 하루 동안 팔린 책의 제목이 입력으로 들어왔을 때, 가장 많이 팔린 책의 제목을 출력하는 프로그램을 작성하시오.

첫째 줄에 오늘 하루 동안 팔린 책의 개수 N이 주어진다. 이 값은 1,000보다 작거나 같은 자연수이다.
둘째부터 N개의 줄에 책의 제목이 입력으로 들어온다. 책의 제목의 길이는 50보다 작거나 같고, 알파벳 소문자로만 이루어져 있다.

첫째 줄에 가장 많이 팔린 책의 제목을 출력한다. 만약 가장 많이 팔린 책이 여러 개일 경우에는 사전 순으로 가장 앞서는 제목을 출력한다.


 */
public class P1302 {

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
