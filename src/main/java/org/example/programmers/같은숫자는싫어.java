package org.example.programmers;

import java.util.ArrayList;
import java.util.List;

public class 같은숫자는싫어 {
    public static void main(String[] args) {
        solution(new int[]{1, 2, 3, 4, 5,5,5,5});
    }
    public static int[] solution(int []arr) {
        int[] answer = {};
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        return distinct(arr);
    }

    public static int[] distinct(int[] arr) {
        int num = 99999999;
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (num != arr[i]) {
                array.add(arr[i]);
                num = arr[i];
            }
        }

        return array
                .stream().mapToInt(x -> x).toArray();
    }


}