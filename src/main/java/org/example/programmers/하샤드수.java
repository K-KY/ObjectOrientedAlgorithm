package org.example.programmers;

public class 하샤드수 {
    public static void main(String[] args) {
        solution(10);
    }

    public static boolean solution(int x) {
        boolean answer = true;
        Number number = new Number(x);
        int sum = number.sumSeperated(number.seperateNumber());
        return number.isAnswer(sum);
    }

}


class Number {
    private final int number;

    public Number(int number) {
        this.number = number;
    }

    public String[] seperateNumber() {
        return String.valueOf(number).split("");
    }

    public boolean isAnswer(int sum) {
        return number % sum == 0;
    }

    public int sumSeperated(String[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += Integer.parseInt(numbers[i]);
        }
        return sum;
    }
}


