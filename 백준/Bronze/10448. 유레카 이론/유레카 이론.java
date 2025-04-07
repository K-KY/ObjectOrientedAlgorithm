import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class Main {
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
