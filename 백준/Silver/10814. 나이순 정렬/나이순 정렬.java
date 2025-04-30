import java.util.*;
public class Main {
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
