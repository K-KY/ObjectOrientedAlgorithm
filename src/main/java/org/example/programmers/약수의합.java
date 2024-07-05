package org.example.programmers;

public class 약수의합 {
    public static void main(String[] args) {
        solution(100);
    }

    public static int solution(int n) {
        int answer = 0;
        MeasureNumber number = new MeasureNumber(n);
        answer = number.remainZero();
        return answer;
    }

}
class MeasureNumber {
    private final int number;

    public MeasureNumber(int number) {
        this.number = number;
    }

    public int remainZero() {
        int count = number;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                count+= i;
            }
        }
        return count;
    }
}
