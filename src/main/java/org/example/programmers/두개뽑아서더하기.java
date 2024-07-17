package org.example.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 두개뽑아서더하기 {
    public static void main(String[] args) {
        PickTwoPlus pickTwoPlus = new PickTwoPlus();
        pickTwoPlus.solution(new int[] {1,2,3,4,5,6,7,8,44});
    }
}

class PickTwoPlus {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        List<Numbers> numArr = toNumber(numbers);
        int[] sums = numPlus(numArr);
        answer = getAnswer(sums);
        return answer;
    }

    public List<Numbers> toNumber(int[] numbers) {
        List<Numbers> numArr = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            numArr.add(new Numbers(numbers[i]));
        }

        return numArr;
    }

    public int[] numPlus(List<Numbers> numArr) {
        int[] sums = new int[201];
        for (int i = 0; i < numArr.size(); i++) {
            Numbers n = numArr.get(i);
            for (int j = i + 1; j < numArr.size(); j++) {
                int m = n.plus(numArr.get(j));
                sums[m] +=1;
            }
        }

        return sums;
    }

    public int max(int n, int m) {
        if (m > n) {
            return m;
        }
        return n;
    }

    public int[] getAnswer(int[] sums) {
        int exist = 0;
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] != 0) {
                sums[exist] = i;
                exist++;
            }
        }
        return Arrays.stream(sums).filter(a -> a >= sums[0]).distinct().toArray();
    }
}

class Numbers {

    private final int num;

    public Numbers(int num) {
        this.num = num;
    }

    public int plus(Numbers number) {
        return num + number.num;
    }
}