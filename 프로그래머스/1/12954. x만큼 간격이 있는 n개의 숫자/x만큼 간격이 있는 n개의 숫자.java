class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for (int i = 1; i <= n; i++) {
            answer[i - 1] = (long) x * (i + i)/2; 
        }
        return answer;
    }
}

//n * (n -1)/2

//3 * (4 +4)/2
//2 * (i + 5)/2