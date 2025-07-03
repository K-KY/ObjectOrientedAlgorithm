package org.example.boj;

import java.util.*;

/**
 * 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다.
 * 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자.
 * 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
 * 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
 * <p>
 * 첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다.
 * 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다.
 * 시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.
 * <p>
 * 17
 * 1 4
 * 0 4
 * 1 17
 * 3 5
 * 0 6
 * 5 7
 * 3 8
 * 5 9
 * 5 15
 * 1 6
 * 6 10
 * 8 11
 * 8 12
 * 2 13
 * 12 14
 * 12 15
 * 16 17
 * <p>
 * 4
 * <p>
 * 회의 시간은 연속되지 않아도 됨
 * 이전 회의가 끝난 시간 보다 크거나 같은 시간 으로 시작하는 회의실
 * 끝나는 시간이 같으면 시작시간 오름차 순
 */

public class P1931 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rooms.add(new Room(scanner.nextInt(), scanner.nextInt()));
        }
        sort(rooms, 0, rooms.size() - 1);

        rooms.sort(Comparator.comparingInt(Room::getEnd).thenComparingInt(Room::getStart));

        rooms.forEach(System.out::println);

        int end = 0;
        int a = 0;
        for (Room room : rooms) {
            if (end <= room.start) {
                end = room.end;
                a++;
            }
        }
        System.out.println(a);

    }

    public static void sort(List<Room> rooms, int low, int high) {
        if (high > low) {
            int partition = partition(rooms, low, high);

            sort(rooms, low, partition - 1);
            sort(rooms, partition + 1, high);
        }
    }

    public static int partition(List<Room> rooms, int low, int high) {
        Room pivot = rooms.get(high);
        int l = low - 1;

        for (int i = low; i < high; i++) {
            if (compare(pivot, rooms.get(i)) > 0) {
                l++;
                swap(rooms, l, i);
            }
        }
        swap(rooms, l + 1, high);
        return l + 1;
    }


    public static void swap(List<Room> rooms, int i, int j) {
        Room temp = rooms.get(i);
        rooms.set(i, rooms.get(j));
        rooms.set(j, temp);
    }

    public static int compare(Room r1, Room r2) {
        if (r1.end == r2.end) {
            return r2.start - r1.start;
        }
        return r1.end - r2.end;
    }

    public static void search() {

    }

    public static class Room {
        int start;
        int end;

        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public String toString() {
            return "Room{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
