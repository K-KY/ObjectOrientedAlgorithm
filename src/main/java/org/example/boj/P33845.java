package org.example.boj;


import java.util.List;
import java.util.Scanner;
import java.util.stream.*;

/*우리는 PNUPC에 한 번도 빠지지 않고 출연한 산지니가 새삼 대단하다고 느껴져 산지니의 아이디에 있는 문자를 출력하지 않기로 했다.

산지니의 아이디와 출력해야 할 문자열이 주어지면 산지니의 아이디에 들어있는 문자를 제거하고 남은 문자열을 출력해 보자.

sanjinee
praisedoesntstop

prdottop

s1을 셋에 저장
s2.replace 순회


*/
public class P33845 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        List<String> chars = Stream.of(in.next().split("")).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.size(); i++) {
            if (s.contains(chars.get(i))) {
                continue;
            }
            sb.append(chars.get(i));
        }
        System.out.println("sb = " + sb);
    }
}
