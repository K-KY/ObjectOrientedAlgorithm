package org.example.boj;

import java.util.*;

/*
온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다.
이때, 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.

첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)

둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다.
 나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수이고, 이름은 알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열이다.
 입력은 가입한 순서로 주어진다.


3
21 Junkyu
21 Dohyun
20 Sunyoung

20 Sunyoung
21 Junkyu
21 Dohyun

*** 나이순, 나이가 같으면 seq비교

 */
public class P10814 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int seq = 0;
        List<Member> members = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] info = in.nextLine().split(" ");
            members.add(new Member(info[1], Integer.parseInt(info[0]), seq));
            seq++;
        }
        sort(members, 0, members.size() - 1);
        members.forEach(m -> System.out.println(m.getAge() + " " + m.getName()));
    }

    private static void sort(List<Member> members, int low, int high) {
        if (high >= low) {
            int partition = partition(members, low, high);
            sort(members, low, partition - 1);
            sort(members, partition + 1, high);
        }
    }

    private static int partition(List<Member> members, int low, int high) {
        Member pivot = members.get(high);
        int l = low - 1;
        for (int i = low; i < high; i++) {
            if (compare(members.get(i), pivot) <= 0) {
                l++;
                swap(members, l, i);
            }
        }
        swap(members, l + 1, high);
        return l + 1;
    }

    private static void swap(List<Member> members, int i, int j) {
        Member temp = members.get(i);
        members.set(i, members.get(j));
        members.set(j, temp);
    }

    private static int compare(Member first, Member second) {
        if (first.age == second.age) {
            return first.seq - second.seq;
        }
        return first.age - second.age;
    }


    public static class Member {
        private final String name;
        private final int age;
        private final int seq;

        public Member(String name, int age, int seq) {
            this.name = name;
            this.age = age;
            this.seq = seq;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public int getSeq() {
            return seq;
        }
    }
}
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = Integer.parseInt(in.nextLine());
//        List<Member> members = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            String[] split = in.nextLine().split(" ");
//            members.add(new Member(split[1], Integer.parseInt(split[0])));
//        }
//        members.stream().sorted(Comparator.comparingInt(Member::getAge)).forEach(s -> System.out.println(s.age + " " + s.name));
//
//    }
//
//    public static class Member {
//        String name;
//        int age;
//        public Member(String name, int age) {
//            this.name = name;
//            this.age = age;
//        }
//
//        public int getAge() {
//
//            return age;
//        }
//    }
//}
