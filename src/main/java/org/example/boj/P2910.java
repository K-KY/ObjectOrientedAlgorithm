package org.example.boj;


import java.util.*;
import java.util.stream.Collectors;

/*

위대한 해커 창영이는 모든 암호를 깨는 방법을 발견했다. 그 방법은 빈도를 조사하는 것이다.

창영이는 말할 수 없는 방법을 이용해서 현우가 강산이에게 보내는 메시지를 획득했다.
이 메시지는 숫자 N개로 이루어진 수열이고, 숫자는 모두 C보다 작거나 같다. 창영이는 이 숫자를 자주 등장하는 빈도순대로 정렬하려고 한다.

만약, 수열의 두 수 X와 Y가 있을 때, X가 Y보다 수열에서 많이 등장하는 경우에는 X가 Y보다 앞에 있어야 한다.
만약, 등장하는 횟수가 같다면, 먼저 나온 것이 앞에 있어야 한다.

이렇게 정렬하는 방법을 빈도 정렬이라고 한다.

수열이 주어졌을 때, 빈도 정렬을 하는 프로그램을 작성하시오.

첫째 줄에 메시지의 길이 N과 C가 주어진다. (1 ≤ N ≤ 1,000, 1 ≤ C ≤ 1,000,000,000)

둘째 줄에 메시지 수열이 주어진다.

5 2
2 1 2 1 2

2 2 2 1 1

9 3
1 3 3 3 2 2 2 1 1

1 1 1 3 3 3 2 2 2

9 77
11 33 11 77 54 11 25 25 33

11 11 11 33 33 25 25 77 54

메세지 객체 생성
빈도
맵 생성
<숫자, 메세지 객체>


**/
public class P2910 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int range = sc.nextInt();

        Map<Integer, Message> messagesMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int value = sc.nextInt();
            if (messagesMap.containsKey(value)) {
                Message message = messagesMap.get(value);
                message.frequency++;
                messagesMap.put(value, message);
                continue;
            }
            messagesMap.put(value, new Message(1, i, value));
        }

        List<Message> messages = messagesMap.values().stream().collect(Collectors.toList());
        sort(messages, 0, messages.size() - 1);

        messages.forEach(message -> System.out.print((message.value + " ").repeat(message.frequency)));
    }

    public static void sort(List<Message> messages, int low, int high) {
        if (low < high) {
            int partition = partition(messages, low, high);
            sort(messages, low, partition - 1);
            sort(messages, partition + 1, high);
        }
    }

    public static int partition(List<Message> messages, int low, int high) {
        Message pivot = messages.get(high);
        int l = low - 1;
        for (int i = low; i < high; i++) {
            if (compare(messages.get(i), pivot) > 0) {
                l++;
                swap(messages, l, i);
            }
        }
        swap(messages, l + 1, high);
        return l + 1;
    }

    public static void swap(List<Message> messages, int i, int j) {
        Message temp = messages.get(i);
        messages.set(i, messages.get(j));
        messages.set(j, temp);
    }

    public static int compare(Message a, Message b) {
        if (a.frequency == b.frequency) {
            return  b.seq - a.seq;//a가 더 크면 뒤로 가야함
        }
        return a.frequency - b.frequency;
    }

    public static class Message {
        private int frequency;
        private int seq;
        private int value;

        public Message(int frequency, int seq, int value) {
            this.frequency = frequency;
            this.seq = seq;
            this.value = value;
        }
    }
}