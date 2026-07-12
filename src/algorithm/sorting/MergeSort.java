package algorithm.sorting;

import java.util.Arrays;

public class MergeSort {

    private static void merge(int[] arr, int l, int mid, int r) {

        int len1 = mid - l + 1;
        int len2 = r - mid;

        int[] arr1 = new int[len1];
        int[] arr2 = new int[len2];

        for (int i = 0; i < len1; i++) {
            arr1[i] = arr[l + i];
        }

        for (int i = 0; i < len2; i++) {
            arr2[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = l;

        while (i < len1 && j < len2) {
            if (arr1[i] <= arr2[j]) {
                arr[k] = arr1[i];
                i++;
                k++;
            } else {
                arr[k] = arr2[j];
                j++;
                k++;
            }
        }

        while (i < len1) {
            arr[k] = arr1[i];
            i++;
            k++;
        }

        while (j < len2) {
            arr[k] = arr2[j];
            j++;
            k++;
        }
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;

            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);

            merge(arr, l, mid, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 0, 5, 7, 3, 2, 1, 4, 8, 6 };

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array " + Arrays.toString(arr));
    }

}
