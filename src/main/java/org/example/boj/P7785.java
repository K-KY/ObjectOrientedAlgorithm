package org.example.boj;

/**
상근이는 세계적인 소프트웨어 회사 기글에서 일한다. 이 회사의 가장 큰 특징은 자유로운 출퇴근 시간이다.
따라서, 직원들은 반드시 9시부터 6시까지 회사에 있지 않아도 된다.

각 직원은 자기가 원할 때 출근할 수 있고, 아무때나 퇴근할 수 있다.

상근이는 모든 사람의 출입카드 시스템의 로그를 가지고 있다. 이 로그는 어떤 사람이 회사에 들어왔는지, 나갔는지가 기록되어져 있다.
로그가 주어졌을 때, 현재 회사에 있는 모든 사람을 구하는 프로그램을 작성하시오.

첫째 줄에 로그에 기록된 출입 기록의 수 n이 주어진다. (2 ≤ n ≤ 106)
다음 n개의 줄에는 출입 기록이 순서대로 주어지며, 각 사람의 이름이 주어지고 "enter"나 "leave"가 주어진다.
 "enter"인 경우는 출근, "leave"인 경우는 퇴근이다.

회사에는 동명이인이 없으며, 대소문자가 다른 경우에는 다른 이름이다. 사람들의 이름은 알파벳 대소문자로 구성된 5글자 이하의 문자열이다.

4
Baha enter
Askar enter
Baha leave
Artem enter

Askar
Artem

5
Baha enter
Askar enter
Baha leave
Artem enter
Caca enter

 */

/*
10000000
 */
import java.io.*;
import java.util.*;

public class P7785 {
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

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = Integer.parseInt(in.nextLine());
//        Map<String, Integer> map = new TreeMap<>(Comparator.reverseOrder());
//        for (int i = 0; i < n; i++) {
//            String[] split = in.nextLine().split(" ");
//            map.put(split[0], isEnter(split[1]));
//        }
//        map.forEach((k, v) -> {
//            if (map.get(k) != 0) {
//                System.out.println(k);
//            }
//        });
//    }
//
//    private static int isEnter(String enter) {
//        if (Objects.equals(enter, "enter")) {
//            return 1;
//        }
//        return 0;
//    }
//}
