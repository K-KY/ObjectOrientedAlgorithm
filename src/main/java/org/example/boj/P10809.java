package org.example.boj;

import java.util.OptionalInt;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.IntStream;


/*
*
*알파벳 소문자로만 이루어진 단어 S가 주어진다. 각각의 알파벳에 대해서,
* 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.

첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.

각각의 알파벳에 대해서, a가 처음 등장하는 위치, b가 처음 등장하는 위치, ... z가 처음 등장하는 위치를 공백으로 구분해서 출력한다.

만약, 어떤 알파벳이 단어에 포함되어 있지 않다면 -1을 출력한다. 단어의 첫 번째 글자는 0번째 위치이고, 두 번째 글자는 1번째 위치이다.

abcd
* 
1 1 1 1
*
 *
* */
public class P10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 'a'; i <= 'z'; i++) {
            sj.add(String.valueOf(str.indexOf((char) i)));
        }
        System.out.println(sj.toString());
        int a = "A".chars().findAny().getAsInt();
        System.out.println("a = " + a);
    }
}
