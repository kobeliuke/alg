package advancedSort;

import simpleSort.Insertion;
import util.Utility;

public class Merge {

    public static void sort(Comparable[] arr) {
        if (arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void sortImprove(Comparable[] arr) {
        if (arr.length < 2) {
            return;
        }
        mergeSortImprove(arr, 0, arr.length - 1);
    }

    public static void sortBT(Comparable[] arr) {
        int len = arr.length;
        if (len < 2) {
            return;
        }

        for (int sz = 1; sz <= len; sz += sz) {
            for (int i = 0; i + sz < len; i += sz + sz) {
                merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, len-1));
            }
        }
    }

    private static void mergeSortImprove(Comparable[] arr, int l, int r) {

        if (r - l <= 15) {
            Insertion.sort(arr, l, r);
        }
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        if (Utility.less(arr[mid + 1], arr[mid])) {
            merge(arr, l, mid, r);
        }

    }

    private static void mergeSort(Comparable[] arr, int l, int r) {

        if (r <= l) return;

        int mid = l + (r - l) / 2;

        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = new Comparable[r - l + 1];

        for (int i = l; i <= r; i++) {
            aux[i - l] = arr[i];
        }

        int lIndex = l;
        int rIndex = mid + 1;
        for (int i = l; i <= r; i++) {

            if (lIndex > mid) {
                arr[i] = aux[rIndex - l];
                rIndex++;
            } else if (rIndex > r) {
                arr[i] = aux[lIndex - l];
                lIndex++;
            } else if (Utility.less(aux[lIndex - l], aux[rIndex - l])) {
                arr[i] = aux[lIndex - l];
                lIndex++;
            } else {
                arr[i] = aux[rIndex - l];
                rIndex++;
            }
        }
    }
}
