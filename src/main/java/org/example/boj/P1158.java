package org.example.boj;

/*
요세푸스 문제는 다음과 같다.

1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다.
한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다.
이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.

N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
7 3

1 2 3 4 5 6 7
1 2 [3] 4 5 6 7
1 2 [3] 4 5 [6] 7
1 [2] [3] 4 5 [6] 7
1 [2] [3] 4 5 [6] [7]
1 [2] [3] 4 [5] [6] [7]
[1] [2] [3] 4 [5] [6] [7]
[1] [2] [3] [4] [5] [6] [7]

1 2 3 4 [5]
[1] 2 3 4 [5]
[1] 2 3 4 [5]

길아가 N인 배열에서
K번 탐색후 나온 값을 제거
제거된 값은 배열로 저장
제거한 인덱스 부터 다시 K번 탐색 후 나온 값제거 반복
만약 배열의 길이가 K보다 작다면 현재 인덱스에서 가장 가까운 값 제거


*/


import java.util.Scanner;
import java.util.StringJoiner;

public class P1158 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int n = in.nextInt();
        int lastRemove = n - 1;
        JosefLinkedList<Integer> list = new JosefLinkedList<>();
        StringJoiner sj = new StringJoiner(", ","<",">");

        for (int i = 1; i <= k; i++) {
            list.add(i);
        }

        for (int i = 0; i < k; i++) {
            //lastRemove 인덱스 삭제
            //lastRemove의 인덱스 저장
            if (i == 0) {
                JosefLinkedList.Node<Integer> delete = list.delete(lastRemove);
                lastRemove = delete.index;
                sj.add(delete.value.toString());
                continue;
            }

            list.indexing();
            JosefLinkedList.Node<Integer> node = list.getNode(lastRemove);
            JosefLinkedList.Node<Integer> delete = list.delete(node.index + (n - 1));
            lastRemove = delete.index;
            sj.add(delete.value.toString());
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
            tail.prev = head;
            return;
        }
        //처음 구조 [1] <-> [1] <-> [1]
        Node<T> newNode = new Node<>(value, head, tail); //새로운 노드 생성, 다음 값이 head, 이전값이 tail
        newNode.index = length - 1;
        tail.next = newNode; // 현재 tail의 다음 값을 새로 생성한 노드로 변경
        tail = newNode;// 현재 tail을 새로 생성한 노드로 변경
        head.prev = tail;//헤드의 이전값을 현재 노드로 변경
        //다음 구조 [1] <-> [2] <-> [1]

    }

    public Node<T> delete(int index) {
        Node<T> node = head;
        System.out.println("node.value = " + node.value);
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

    public T get(int index) {
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    public Node<T> getNode(int index) {
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public T getPrev(int index) {
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.prev;
        }
        return node.value;
    }

    public void indexing() {
        Node<T> node = head;
        for (int i = 0; i < length; i++) {
            node.index = i;
            node = node.next;
        }
    }
}

/*
5
5

> Task :org.example.boj.P1158.main()
<5, 1, 3, 4, 2>

*/