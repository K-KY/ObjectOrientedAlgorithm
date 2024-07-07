package org.example.programmers;

public class 정수내림차순으로배치하기 {

    public static void main(String[] args) {
        long solution = solution(1234567890);
        System.out.println("solution = " + solution);
    }
    public static long solution(long n) {
        long answer = 0;
        Proper proper = new Proper(n);
        answer = proper.reverseSort();
        return answer;
    }

}

class Proper {
    private final long longNum;

    public Proper(long longNum) {
        this.longNum = longNum;
    }


    public Long reverseSort() {
        int[] count = NumberCounter.numberCounter(longNum);
        String asw = "";
        for (int i = count.length - 1; i >= 0; i--) {
            //System.out.println(count[i]);
            int cnt = count[i];
            for (int j = 0; j < cnt; j++ ) {
                asw+=i;
            }
        }
        return Long.parseLong(asw);
    }
}

class NumberCounter {

    public static int[] numberCounter(long longNum) {
        String[] n = String.valueOf(longNum).split("");
        int[] arr = new int[10];


        for (int i = 0; i < n.length; i++) {
            arr[Integer.parseInt(n[i])]+=1;
        }

        return arr;
    }
}
