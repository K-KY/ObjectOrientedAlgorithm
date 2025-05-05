import java.util.*;
import java.util.stream.Collectors;
public class Main {
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
            return b.seq - a.seq;//a가 더 크면 뒤로 가야함
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