package org.example.boj;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
* 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
 */


public class P1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] targetArr = sc.nextLine().toUpperCase().chars().toArray();
        int[] count = new int[26];
        char answer = 0;
        int noc = 0;

        for (int i = 0; i < targetArr.length; i++) {
            count[targetArr[i] - 'A']++;
        }

        for (int i = 0; i < count.length; i++) {
            if (noc < count[i]) {
                noc = count[i];
                answer = (char)(i + 'A');
                continue;
            }

            if (noc == count[i]) {
                answer = '?';
            }
        }
        System.out.println("answer = " + answer);
    }
}
