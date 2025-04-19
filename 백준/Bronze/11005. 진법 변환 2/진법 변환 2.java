import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int quotient = arr[0];  // 몫
        int base = arr[1];      // 진법
        Stack<Integer> remainder = new Stack<>();   // 나머지 값을 넣을 스택

        while (quotient > 0 && quotient !=0) {
            remainder.push(quotient % base);    // 나머지값 스택에 저장
            quotient = quotient / base;         // 나눈 후 몫 저장
        }

        // 스택에서 하나씩 꺼내어 결과 출력 (단, 10부터는 알파벳으로 변환)
        while(!remainder.isEmpty()) {
            int num = remainder.pop();
            if(num >= 10)
                bw.write((char)((num - 10) + 'A'));//???????
            else 
		            bw.write(num + "");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}