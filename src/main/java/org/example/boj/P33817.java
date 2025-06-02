package org.example.boj;

import java.util.*;
import java.util.stream.Collectors;

public class P33817 {

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
        // 1차 그룹: 상위 10명 무조건 선발
        int i = 0;
        while (selected.size() < 10 && i < tak.size()) {
            selected.add(tak.get(i).id);
            i++;
        }

        // 2차 그룹: 나머지 중 score < 2 인 사람 중에서 선발
        int j = i;
        while (selected.size() < 20 && j < tak.size()) {
            if (tak.get(j).score < 2) {
                selected.add(tak.get(j).id);
            }
            j++;
        }

        // 오름차순 정렬 후 출력
        Collections.sort(selected);
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


        @Override
        public String toString() {
            return "Participant{" +
                    "apply='" + apply + '\'' +
                    ", score=" + score +
                    ", id=" + id +
                    '}';
        }
    }
}
