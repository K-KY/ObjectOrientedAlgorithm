package org.example.programmers;

public class 삼각형의완성조건 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr ={1,2};
        solution.solution(arr);
    }
}

class Solution {
    public int solution(int[] sides) {
        int answer = 0;

        Line lineF = new Lines(sides[0]);
        Line lineS = new Lines(sides[1]);

        int lineSum = lineF.lineSum(lineS);
        int minLength = lineF.lineMin(lineS);
        int maxLength = lineSum - 1;
        answer = maxLength - minLength + 1;

        return answer;
    }
}

class Lines implements Line {
    private final int lineLength;

    public Lines(int lineLength) {
        this.lineLength = lineLength;
    }

    @Override
    public int sum(int number) {
        return number + lineLength;
    }

    @Override
    public int minLength(int number) {
        return Math.abs(number - lineLength) + 1;
    }

    @Override
    public int lineSum(Line otherLine) {
        return otherLine.sum(lineLength);
    }

    @Override
    public int lineMin(Line otherLine) {
        return otherLine.minLength(lineLength);
    }

    @Override
    public int lineMax(Line number) {
        return 0;
    }
}

interface Line {
    int lineSum(Line other);
    int lineMin(Line other);
    int lineMax(Line other);
    int sum(int number);
    int minLength(int number);
}

