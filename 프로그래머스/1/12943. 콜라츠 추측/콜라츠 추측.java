import java.util.*;
class Solution {
    public int solution(long num) {
        int answer = -1;
        if (num == 1) {
            return 0;
        }
        
        for (int i = 0; i < 500; i++) {
            if (num % 2 == 0) {
                num = num / 2;
                continue;
            }
            
            
            if (num % 2 != 0 && num != 1) {
                num = num * 3 + 1;

                continue;
            }
            
            if (num == 1) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}