package org.example.boj;


import java.util.*;

/*
알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.

길이가 짧은 것부터
길이가 같으면 사전 순으로
단, 중복된 단어는 하나만 남기고 제거해야 한다.
13
but
i
wont
hesitate
no
more
no
more
it
cannot
wait
im
yours

i
im
it
no
but
more
wait
wont
yours
cannot
hesitate

    1      2       3       4   5   ...
  /       /\

 글자수 맵으로 넣고 글자수의 깊이 만큼 노드 생성

*/
public class P1181 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] words = new String[n];

        int unqWords = 0;
        for (int i = 0; i < n; i++) {
            String word = in.nextLine();
            if (contains(words, word)) {
                continue;
            }
            words[unqWords] = word;
            unqWords++;
        }

        String[] uniq = new String[unqWords];
        for (int i = 0; i < unqWords; i++) {
            uniq[i] = words[i];
        }

        quickSort(uniq, 0, uniq.length - 1);

        for (int i = 0; i < uniq.length; i++) {
            System.out.println(uniq[i]);
        }
    }

    private static boolean contains(String[] words, String word) {
        for (int i = 0; i < words.length; i++) {
            if (Objects.equals(words[i], word)) {
                return true;
            }
        }
        return false;
    }

    private static void quickSort(String[] words, int low, int high) {
        if (low <= high) {
            int p = partition(words, low, high);
            quickSort(words, low, p - 1);
            quickSort(words, p + 1, high);
        }
    }

    private static int compare(String a, String b) {
        if (a.length() != b.length()) {
            return a.length() - b.length();
        }
        return a.compareTo(b);
    }

    private static int partition(String[] words, int low, int high) {
        String pivot = words[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (compare(words[j], pivot) <= 0) {
                i++;
                swap(words, i, j);
            }
        }
        swap(words, i + 1, high);
        return i + 1;
    }

    private static void swap(String[] words, int i, int j) {
        String temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }
}































//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        String[] words = new String[n];
//        int size = 0;
//
//        // 입력 및 중복 제거
//        for (int i = 0; i < n; i++) {
//            String word = br.readLine();
//            if (!contains(words, size, word)) {
//                words[size++] = word; // 중복 없으면 삽입
//            }
//        }
//
//        // 필요한 만큼만 잘라서 정렬
//        String[] uniqueWords = new String[size];
//        for (int i = 0; i < size; i++) {
//            uniqueWords[i] = words[i];
//        }
//
//        // 직접 정렬
//        quickSort(uniqueWords, 0, size - 1);
//
//        // 출력
//        for (int i = 0; i < size; i++) {
//            System.out.println(uniqueWords[i]);
//        }
//    }
//
//    // 중복 확인 함수
//    static boolean contains(String[] arr, int size, String target) {
//        for (int i = 0; i < size; i++) {
//            if (arr[i].equals(target)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    // 퀵정렬
//    static void quickSort(String[] arr, int left, int right) {
//        if (left >= right) return;
//
//        int pivot = partition(arr, left, right);
//        quickSort(arr, left, pivot - 1);
//        quickSort(arr, pivot + 1, right);
//    }
//
//    // 정렬 기준: 길이 → 사전순
//    static int compare(String a, String b) {
//        if (a.length() != b.length()) {
//            return a.length() - b.length();
//        }
//        return a.compareTo(b);
//    }
//
//    static int partition(String[] arr, int left, int right) {
//        String pivot = arr[right];
//        int i = left - 1;
//
//        for (int j = left; j < right; j++) {
//            if (compare(arr[j], pivot) <= 0) {
//                i++;
//                swap(arr, i, j);
//            }
//        }
//
//        swap(arr, i + 1, right);
//        return i + 1;
//    }
//
//    static void swap(String[] arr, int i, int j) {
//        String tmp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = tmp;
//    }
//}


//    public static void main(String[] args) {
//
//        Scanner in = new Scanner(System.in);
//        TreeSet<String> set = new TreeSet<>(Comparator.comparingInt(String::length).thenComparing(String::compareTo));
//        int n = in.nextInt();
//        for (int i = 0; i < n; i++) {
//            String s = in.next();
//            set.add(s);
//        }
//        set.forEach(System.out::println);
//    }
//    public static void main(String[] args) {
//        Map<Integer, Set<Literal>> map = new HashMap<>();
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        for (int i = 0; i < n; i++) {
//            String s = sc.next();
//            Set<Literal> orDefault = map.getOrDefault(s.length(), new HashSet<>());
//            orDefault.add(new Literal(s));
//            map.putIfAbsent(s.length(), orDefault);
//        }
//
//
//        map.forEach((k, v) -> {
//            v.stream().sorted(Comparator.comparingInt(Literal::getScore)).forEach(System.out::println);
//        });
//
//    }
//}
//
//class Literal {
//    private final String value;
//    private int score;
//    public Literal(String value) {
//        this.value = value;
//        score = calcScore();
//    }
//
//    private int calcScore() {
//        System.out.println("value.chars().boxed() = " + value.chars().boxed().toList());
//        return value.chars().reduce(0, (a, b) -> (
//                String.valueOf(a).chars().sum() + String.valueOf(b).chars().sum()));
//    }
//
//    public int getScore() {
//        return score;
//    }
//
//    @Override
//    public String toString() {
//        return "Literal{" +
//                "value='" + value + '\'' +
//                ", score=" + score +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (o == null || getClass() != o.getClass()) return false;
//        Literal literal = (Literal) o;
//        return score == literal.score && Objects.equals(value, literal.value);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(value, score);
//    }
//}
//
//class Sort {
//    public void quickSort(List<Integer> arr, int low, int high) {
//        if (low < high) {
//            int partition = partition(arr, low, high);
//
//            quickSort(arr, low, partition - 1);
//            quickSort(arr, low, partition + 1);
//        }
//    }
//
//    private int partition(List<Integer> arr, int low, int high) {
//        int pivot = arr.get(high);
//        int l = low - 1;
//
//        for (int i = low; i < high; i++) {
//            if (arr.get(i) <= pivot) {
//                l++;
//                swap(arr, l, i);
//            }
//        }
//        swap(arr, l + 1, high);
//        return l + 1;
//    }
//
//    private void swap(List<Integer> arr, int i, int j) {
//        int temp = arr.get(i);
//        arr.set(i, arr.get(j));
//        arr.set(j, temp);
//    }
//}

/*
13
but
i
wont
hesitate
no
more
no
more
it
cannot
wait
im
zzzzzzzzzzzzzzzzzzzzzzzz
*/