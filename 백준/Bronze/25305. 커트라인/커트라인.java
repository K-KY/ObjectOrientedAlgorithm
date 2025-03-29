import java.util.*;
import java.io.*;
public class Main{
    static int[] sorted;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int cut = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[num];
        for(int i = 0; i < num; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(arr,0,arr.length-1);
        System.out.println(arr[arr.length-cut]);
    }
    static void mergeSort(int[] arr, int start, int end){
        if(start==end){
            return;
        }
        sorted = new int [arr.length];
        int middle = (start+end) / 2;
        mergeSort(arr, start, middle);
        mergeSort(arr, middle+1, end);
        merge(arr, start, middle, end);
    }
    static void merge(int[] arr, int start, int middle, int end){
        int stt= start;
        int m = middle + 1;
        int i = start;
        while(stt <= middle && m <= end){
            if(arr[stt]<=arr[m]){
                sorted[i] = arr[stt];
                stt++;
            }else{
                sorted[i] = arr[m];
                m++;
            }
            i++;
        }
        while(stt<=middle){
            sorted[i] = arr[stt];
            i++;
            stt++;
        }
        while(m <= end){
            sorted[i] = arr[m];
            i++;
            m++;
        }
        for(i = start; i<=end; i++){
            arr[i] = sorted[i];
        }
    }
    
    
}