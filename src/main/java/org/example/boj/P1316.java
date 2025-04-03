package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
*그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.
* 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만,
* aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.

단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
*
* 문자열의 문자 카운팅
* 사용된 문자 저장
* 이전에 사용된 문자 저장
* 이전에 사용된 문자가 아닌데 사용된 문자 배열에 있다면 false
*

*

* */
public class P1316 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(reader.readLine());//반복 횟수
        int a = 0;//답
        for (int j = 0; j < i; j++) {
            String s = reader.readLine();

            if (isTrue(s)) {
                a++;
            }

        }
        System.out.println("a = " + a);
    }

    public static boolean isTrue(String s) {
        char prev = '@';//직전에 사용된 문자
        List<Character> chars = new ArrayList<>();//사용된 문자 배열
        for (int i = 0; i < s.length(); i++) {
            if (prev != s.charAt(i) && chars.contains(s.charAt(i))) {
                //이전에 사용된 문자가 아닌데 사용된 문자 배열에 포함 되어있으면 false
                return false;
            }
            chars.add(s.charAt(i));//사용된 문자 배열에 저장
            prev = s.charAt(i);//직전 사용문자 재정의
        }
        return true;
    }
}
