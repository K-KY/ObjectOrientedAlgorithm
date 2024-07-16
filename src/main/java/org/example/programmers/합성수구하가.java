package org.example.programmers;

public class 합성수구하가 {
    public static void main(String[] args) {
        CompositeNumber compositeNumber = new CompositeNumber();
        compositeNumber.solution(10);
    }
}

class CompositeNumber {
    public int solution(int n) {
        int answer = 0;
        FusionNumbers f = new FusionNumbers(n);
        answer = f.amount();
        return answer;
    }
}
class FusionNumbers {
    private final int number;

    public FusionNumbers(int number) {
        this. number = number;
    }

    public int amount() {
        int amount = 0;

        for (int i = 1; i <= number; i++) {
            if (remainZero(i)) {
                amount++;
            };
        }
        return amount;
    }

    private boolean remainZero(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                System.out.println(number);
                return true;
            }
        }
        return false;
    }
}
