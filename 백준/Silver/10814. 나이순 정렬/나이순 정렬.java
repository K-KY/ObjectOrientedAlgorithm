import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] split = in.nextLine().split(" ");
            members.add(new Member(split[1], Integer.parseInt(split[0])));
        }
        members.stream().sorted(Comparator.comparingInt(Member::getAge)).forEach(s -> System.out.println(s.age + " " + s.name));

    }

    public static class Member {
        String name;
        int age;
        public Member(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {

            return age;
        }
    }
}
