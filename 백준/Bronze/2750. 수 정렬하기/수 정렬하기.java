import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i = 1; i < arr.length; i++) {
            int child = i;
            do {
                int root = (child -1) /2;
                if(arr[child] > arr[root]){
                    int temp = arr[child];
                    arr[child] = arr[root];
                    arr[root] = temp;
                }
                child = root; // 최상위 노드는 제외하고 root 노드를 확인했으면 확인한 root 노드의 root로 간다
            } while(child != 0);
        }
        //여기 까지가 완전 2진트리로 만드는 과정
        
        for(int i = num -1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            int root = 0;
            int child;
            do {
                child = root * 2 + 1;
                //자식노드보다 큰 노드 확인
                if(child < i -1 && arr[child]<arr[child+1]) {
                    child++;
                }
                //root 노드보다 크면 스왑
                if(child < i && arr[root] < arr[child]) {
                    temp = arr[root];
                    arr[root] = arr[child];
                    arr[child] = temp;
                }
                root = child;
                //child 의 자식 노드를 확인하기 위해 root 를 child 로 만든다
                
            } while(child < i);

        }
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);    
        }
        
    }
}