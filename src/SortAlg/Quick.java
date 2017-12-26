package SortAlg;

import util.Utility;

import java.util.Random;

public class Quick {

    public static void sort(Comparable[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void sortImprove(Comparable[] arr) {
        quickSortImprove(arr, 0, arr.length - 1);
    }

    private static void quickSortImprove(Comparable[] arr, int l, int r) {
        if (r - l <= 15) {
            Insertion.sort(arr, l, r);
        }

        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    private static void quickSort(Comparable[] arr, int l, int r) {

        if (l >= r) return;

        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    //返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r) {

        int pos = new Random().nextInt(r-l+1) + l;
        Utility.exchange(arr,l,pos);
        Comparable v = arr[l];
        // arr[l+1...j] < v ; arr[j+1...i) > v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (Utility.less(arr[i], v)) {
                j++;
                Utility.exchange(arr, j, i);
            }
        }
        Utility.exchange(arr, j, l);
        return j;
    }

}
