import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        Sort sort = new Sort(array);

        for (int i = 0; i < commands.length; i++) {
            int ints = sort.cloneArray(commands[i][0], commands[i][1], commands[i][2]);
            answer[i] = ints;
        }

        return answer;
    }
}

class Sort {
    private int[] original;
    public Sort(int[] original) {
        this.original = original;
    }

    public int cloneArray(int m, int n, int o) {
        int[] range = new int[n - m + 1];
        for (int i = 0; i < range.length; i++) {
            range[i] = original[i + m - 1];
        }
        return sort(range, o);
    }

    public int sort(int[] array, int i) {
        return Arrays.stream(array).sorted().toArray()[i-1];
    }
}
