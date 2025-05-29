import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int target = sc.nextInt();
        int[] homes = new int[len];
        for (int i = 0; i < len; i++) {
            homes[i] = sc.nextInt();
        }
        Arrays.sort(homes);
        
        System.out.println(binarySearch(homes, target));

    }


//0번부터 length - a[0] 까지
    //a[n] - last 가 mid보다 크거나 같다면 설치
    //작다면 스킵

    public static int binarySearch(int[] homes, int target) {
        int low = 1;
        int high = homes[homes.length - 1] - homes[0];
        int ans = 0;
        while (low <= high) {
            int last = homes[0];
            int placed = 1;
            int mid = (low + high) / 2;

            //전부 순회 해보고 남은 공유기 수 확인
            for (int i = 0; i < homes.length; i++) {
                if (homes[i] - last >= mid) {
                    placed++;
                    last = homes[i];
                }
            }

            //설치된게 target보다 크거나 같으면 mid가 답
            //클 필요가 있는 이유는 위 반복문에서 target 과 같아진경우 탈출 조건을 안 넣어줬기 때문
            if (placed >= target) {
                ans = mid;
                low = mid + 1;//mid를 더 키워서 다시 탐색
            }

            //다 설치하지 못한 경우 mid를 줄여서 다시 탐색
            if (placed < target) {
                high = mid - 1;
            }
        }
        return ans;
    }
}
