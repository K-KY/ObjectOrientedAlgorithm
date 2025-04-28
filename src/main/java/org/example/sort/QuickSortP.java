package org.example.sort;

//배열의 피벗을 정함
//작은 요소의 인덱스를 저장
//배열을 순회 하면서 피벗보다 작거나 같은 값을 찾음
//  찾았으면 i를 1 증가시키고 i와 순회 인덱스를 교체

import java.util.Arrays;
import java.util.List;

public class QuickSortP {
    public static void main(String[] args) {
        QuickSortP quickSortP = new QuickSortP();
        List<Integer> arr = Arrays.asList(4,1,2,5,3,8);
        quickSortP.quickSort(arr, 0, arr.size() - 1);
        System.out.println("arr = " + arr);
    }

    private int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(high);// 피벗
        int i = low - 1;//작은 요소의 인덱스
        for (int j = low; j < high; j++) {
            if (arr.get(j) <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    public void quickSort(List<Integer> arr, int low, int high) {
        if (low < high) {//low가 high보다 작아야함
            int quickSort = partition(arr, low, high);
            quickSort(arr, low, quickSort - 1);
            quickSort(arr, quickSort + 1, high);

        }
    }

    public void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}
