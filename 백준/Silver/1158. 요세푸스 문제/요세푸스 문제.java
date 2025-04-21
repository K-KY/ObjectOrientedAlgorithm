import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();  // 총 인원 수
        int k = in.nextInt();  // 제거할 순번

        JosefLinkedList<Integer> list = new JosefLinkedList<>();
        StringJoiner sj = new StringJoiner(", ", "<", ">");

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int currentIndex = 0;

        while (list.length > 0) {
            currentIndex = (currentIndex + (k - 1)) % list.length;
            list.indexing(); // 인덱스 재정렬
            JosefLinkedList.Node<Integer> deleted = list.delete(currentIndex);
            sj.add(deleted.value.toString());
        }

        System.out.println(sj);
    }
}

class JosefLinkedList<T> {
    Node<T> head;
    Node<T> tail;
    int length = 0;

    public static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;
        int index;

        public Node(T value, Node<T> next, Node<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public void add(T value) {
        length++;
        if (head == null) {
            head = new Node<>(value, null, null);
            head.index = 0;
            tail = head;
            head.next = head;
            head.prev = head;
            return;
        }

        Node<T> newNode = new Node<>(value, head, tail);
        newNode.index = length - 1;
        tail.next = newNode;
        head.prev = newNode;
        tail = newNode;
    }

    public Node<T> delete(int index) {
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        if (node == head) {
            head = head.next;
        }
        if (node == tail) {
            tail = tail.prev;
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;

        length--;

        if (length == 0) {
            head = null;
            tail = null;
        }

        return node;
    }

    public void indexing() {
        if (length == 0) return;

        Node<T> node = head;
        for (int i = 0; i < length; i++) {
            node.index = i;
            node = node.next;
        }
    }
}
