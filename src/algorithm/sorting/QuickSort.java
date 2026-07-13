package algorithm.sorting;

import java.util.Arrays;

public class QuickSort {

    private static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];

        int i = l - 1;

        for (int j = l; j < r; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = temp;
        return i + 1;
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int pivotIndex = partition(arr, l, r);
            quickSort(arr, l, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 1, 0, 5, 2, 4, 7, 8, 6 };
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array " + Arrays.toString(arr));

    }
}
