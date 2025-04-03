package org.example.boj;


import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
* 첫째 줄에는 현재 시각이 hh:mm:ss로 주어진다. 시간의 경우 0≤h≤23 이며, 분과 초는 각각 0≤m≤59, 0≤s≤59 이다.

두 번째 줄에는 소금 투하의 시간이 hh:mm:ss로 주어진다.

출력
로봇팔이 소금을 투하할때까지 필요한 시간을 hh:mm:ss로 출력한다. 이 시간은 1초보다 크거나 같고, 24시간보다 작거나 같다.


* 20:00:00
04:00:00

* 08:00:00
*
*

* */
public class P13223 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] current = timeSeperator(sc.nextLine());
        int[] target = timeSeperator(sc.nextLine());

        int h = target[0]-current[0];
        int m = target[1]-current[1];
        int s = target[2]-current[2];

        if(s<0) {
            s+=60;
            m--;
        }
        if(m<0) {
            m+=60;
            h--;
        }
        if(h<0) {
            h+=24;
        }
        if(h==0 & m==0 & s==0) {
            h=24;
        }

        System.out.printf("%02d:%02d:%02d", h, m, s);


    }

    static int[] timeSeperator(String times) {
        return Arrays.stream(times.split(":")).mapToInt(Integer::parseInt).toArray();
    }
}
