import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rooms.add(new Room(scanner.nextInt(), scanner.nextInt()));
        }
        rooms.sort(new Comparator<Room>() {
            @Override
            public  int compare(Room r1, Room r2) {
                if (r1.end == r2.end) {
                    return r1.start - r2.start;
                }
                return r1.end - r2.end;
            }
        });


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
    }
}
