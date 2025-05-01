import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
public class Main {
    //정렬한 리스트가 필요함
    //n이 입력 되면 n보다 작은 값을 이분 탐색으로 찾음

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> coordinate = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());


        List<Integer> sorted = new ArrayList<>(coordinate);
        Collections.sort(sorted);

        int[] unique = sorted.stream().distinct().mapToInt(Integer::intValue).toArray();
        StringJoiner joiner = new StringJoiner(" ");
        for (int i = 0; i < coordinate.size(); i++) {
            int s = binarySearch(unique, coordinate.get(i));
            joiner.add(s + "");
        }

        System.out.println(joiner);
    }

    public static int binarySearch(int[] unique, int n) {

        int left = 0;
        int right = unique.length - 1;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (unique[mid] < n) {
                answer = mid + 1;
                left = mid + 1;
            }
            if (unique[mid] >= n) {
                right = mid - 1;
            }
        }

        return answer;
    }

    public static void sort(List<Integer> coordinate, int low, int high) {
        if (low < high) {
            int partition = partition(coordinate, low, high);
            sort(coordinate, low, partition - 1);
            sort(coordinate, partition + 1, high);
        }
    }

    public static int partition(List<Integer> coordinate, int low, int high) {
        int pivot = coordinate.get(high);
        int l = low - 1;

        for (int i = low; i < high; i++) {
            if (coordinate.get(i) < pivot) {
                l++;
                swap(coordinate, l, i);
            }
        }
        swap(coordinate, l + 1, high);
        return l + 1;
    }
    public static void swap(List<Integer> coordinate, int i, int j) {
        int temp = coordinate.get(i);
        coordinate.set(i, coordinate.get(j));
        coordinate.set(j, temp);
    }
}
