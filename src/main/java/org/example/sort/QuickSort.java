package org.example.sort;

import java.util.List;
/*
* 퀵정렬 개념
*
* 피벗을 정한다.
* 왼쪽, 오른쪽, 중간 방식이 있음
*
* 정한 피벗을 기준
* 왼 쪽에서는 피벗보다 큰 값 오른 쪽에서는 피벗보다 작은 값을 찾는다.
*
*1, 4, 6, 2, 3, 9, 10, 5, 7, 8
*
* 1이 피벗
* 왼쪽에선 1보다 큰 값
* 오른 쪽에선 1보다 작은 값
* 왼 : 4
* 오 : 1
*
* 왼쪽의 인덱스가 오른쪽의 인덱스보다 큼
* */
public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 피벗 위치 찾기
            int pivotIndex = partition(arr, low, high);

            // 피벗 기준으로 좌/우 정렬
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 마지막 요소를 피벗으로 설정
        int i = low - 1;       // 작은 요소의 인덱스

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {//배열을 순회하면서 피벗보다 작은 값을 찾음
                //피벗 보다 큰 값을 발견하면 그냥 지나가고 i와 j의 값에 차이가 생김
                //
                i++;
                swap(arr, i, j);//피벗보다 작은 값을 찾으면 low값과 j를 교체
            }
        }

        swap(arr, i + 1, high);//전부 순회를 하고 나면
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 6, 2, 3, 9, 10, 5, 7, 8 };
        int n = arr.length;

        System.out.println("정렬 전 배열:");
        printArray(arr);

        quickSort(arr, 0, n - 1);

        System.out.println("정렬 후 배열:");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}


