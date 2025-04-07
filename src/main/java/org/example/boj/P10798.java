package org.example.boj;

import java.util.*;
import java.util.stream.Collectors;

public class P10798 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Queue<String>> arr = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String s = in.nextLine();
            Queue<String> queue = new LinkedList<>(List.of(s.split("")));
            arr.add(queue);
        }

        while (!arr.isEmpty()) {
            arr = arr.stream().filter(a -> !a.isEmpty()).collect(Collectors.toList());
            for (Queue<String> queue : arr) {
                if (queue.peek() != null) {
                    String poll = queue.poll();
                    System.out.print(poll);
                }
            }
        }
    }

//        Queue<String> strings = arr.stream().filter(q -> !q.isEmpty()).findFirst().get();
//        while (!strings.isEmpty()) {
//            System.out.print(strings.poll());
//        }
}

/*
 * a
 * abcde
 * abcd
 * abc
 * abcdefghijk
 * */