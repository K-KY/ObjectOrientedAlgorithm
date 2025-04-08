import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int spent = 0;
        Arrays.sort(d);
        for (int i = 0; i < d.length; i++) {
            spent+=d[i];
            answer++;
            if (spent > budget) {
                answer--;
                break;
            }
            if (spent == budget) {
                break;
            }
        }
        return answer;
    }
}