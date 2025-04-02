import java.io.*;
import java.util.*;

//직전 문자 저장 -> char prev
//사용된 문자 배열 저장 -> list used
//현재 문자와 직전 문자와 다른데 사용된 문자 배열에 현재 문자가 있다면 그룹 단어가 아님

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int roop = Integer.parseInt(reader.readLine());
        int answer = 0;
        for (int i = 0; i < roop; i++) {
            String target = reader.readLine();
            if (isTrue(target)) {
                answer++;
            }
        }
        System.out.println(answer);
    }
    
    public static boolean isTrue(String target) {
        Set<Character> used = new HashSet();
        char prev = '@';
        for (int i = 0; i < target.length(); i++) {
            char turn = target.charAt(i);
            if (turn != prev && used.contains(turn)) {
                return false;
            };
            prev = turn;
            used.add(turn);
        }
        return true;
    }
}