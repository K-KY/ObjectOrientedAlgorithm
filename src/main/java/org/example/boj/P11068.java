package org.example.boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

/*
 * 어떤 수를 왼쪽부터 읽어도, 오른쪽부터 읽어도 같을 때 이 수를 회문인 수라고 한다.
 *  예를 들어, 747은 회문인 수이다. 255도 회문인 수인데, 16진수로 표현하면 FF이기 때문이다.
 * 양의 정수를 입력받았을 때, 이 수가 어떤 B진법 (2 ≤ B ≤ 64)으로 표현하면 회문이 되는 경우가 있는지 알려주는 프로그램을 작성하시오.
 * B진법이란, 한 자리에서 수를 표현할 때 쓸 수 있는 수의 가짓수가 B라는 뜻이다. 예를 들어, 십진법에서 B는 10이다.

 *
 */
public class P11068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringJoiner sj = new StringJoiner("\n");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int target = sc.nextInt();
            for (int j = 2; j <= 64; j++) {
                if (isSymmetrical(convert(target, j))) {
                    sj.add("1");
                    break;
                }
                if (j == 64 && !isSymmetrical(convert(target, j))) {
                    sj.add("0");
                }
            }
        }
        System.out.println(sj);
    }

    public static List<Integer> convert(int number, int radix) {
        List<Integer> numbers = new ArrayList<>();
        while (number > 0) {
            numbers.add(number % radix);
            number /= radix;
        }
        return numbers;
    }

    public static boolean isSymmetrical(List<Integer> numbers) {
        int start = 0;
        int end = numbers.size() - 1;
        while (start <= end) {

            int s = numbers.get(start);
            int e = numbers.get(end);
            if (s != e) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}