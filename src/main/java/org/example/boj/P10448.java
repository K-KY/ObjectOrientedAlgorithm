package org.example.boj;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
자연수 n에 대해 n ≥ 1의 삼각수 Tn는 명백한 공식이 있다.

Tn = 1 + 2 + 3 + ... + n = n(n+1)/2

1796년, 가우스는 모든 자연수가 최대 3개의 삼각수의 합으로 표현될 수 있다고 증명하였다. 예를 들어,

4 = T1 + T2
5 = T1 + T1 + T2
6 = T2 + T2 or 6 = T3
10 = T1 + T2 + T3 or 10 = T4
이 결과는 증명을 기념하기 위해 그의 다이어리에 “Eureka! num = Δ + Δ + Δ” 라고 적은것에서 유레카 이론으로 알려졌다.
꿍은 몇몇 자연수가 정확히 3개의 삼각수의 합으로 표현될 수 있는지 궁금해졌다.
 위의 예시에서, 5와 10은 정확히 3개의 삼각수의 합으로 표현될 수 있지만 4와 6은 그렇지 않다.

자연수가 주어졌을 때, 그 정수가 정확히 3개의 삼각수의 합으로 표현될 수 있는지 없는지를 판단해주는 프로그램을 만들어라.
단, 3개의 삼각수가 모두 달라야 할 필요는 없다.




3각수는 n(n+1)/2을 만족하는 숫자를 의미함
3각수를 구하는 문제가 아니라 3개의 3각수의 합으로 이루어진 수를 찾는 문제임

3각수 리스트를 만든다.

3중 반복문 사용
*/
public class P10448 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] cases = new int[Integer.parseInt(in.readLine())];
        int start = 0;
        for (int i = 0; i < cases.length; i++) {
            cases[i] = Integer.parseInt(in.readLine());
        }

        List<Integer> triNums = new ArrayList<>();

        for (int i = 1; i <= 50; i++) {
            triNums.add(i * (i + 1) / 2);
        }

        while (start < cases.length) {
            for (int i = 0; i < triNums.size(); i++) {
                for (int j = 0; j < triNums.size(); j++) {
                    for (int k = 0; k < triNums.size(); k++) {
                        if (triNums.get(i) + triNums.get(j) + triNums.get(k) == cases[start]) {
                            start++;
                            i = triNums.size();
                            j = i;
                            j = j;
                            System.out.println(1);
                            break;
                        }

                        if (triNums.get(i) >= cases[start]) {
                            start++;
                            i = triNums.size();
                            j = i;
                            j = j;
                            System.out.println(0);
                            break;
                        }
                    }
                }
            }
        }
    }
}
/*
3
10
20
10
*/
