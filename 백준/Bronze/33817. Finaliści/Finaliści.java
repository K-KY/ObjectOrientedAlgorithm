import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Participant> participantList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            participantList.add(new Participant(sc.next(), sc.nextInt(), i + 1));
        }

        List<Participant> tak = participantList.stream()
                .filter(p -> p.apply.equals("TAK")).collect(Collectors.toList());

        List<Integer> selected = new ArrayList<>();
        int i = 0;
        while (selected.size() < 10 && i < tak.size()) {
            selected.add(tak.get(i).id);
            i++;
        }

        int j = i;
        while (selected.size() < 20 && j < tak.size()) {
            if (tak.get(j).score < 2) {
                selected.add(tak.get(j).id);
            }
            j++;
        }

        for (int id : selected) {
            System.out.print(id + " ");
        }

    }
    public static class Participant {
        private String apply;
        private int score;
        private int id;
        public Participant(String apply, int score, int id) {
            this.apply = apply;
            this.score = score;
            this.id = id;
        }
    }
}
