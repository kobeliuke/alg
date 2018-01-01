package advancedSort;

import simpleSort.Insertion;
import util.Utility;

import java.util.Random;

public class Quick {

    public static void sort(Comparable[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void sort2(Comparable[] arr) {
        quickSort2(arr, 0, arr.length - 1);
    }

    public static void sort3(Comparable[] arr) {
        quickSort3Ways(arr, 0, arr.length - 1);
    }

    private static void quickSort3Ways(Comparable[] arr, int l, int r) {
        if (r - l <= 14) {
            Insertion.sort(arr, l, r);
            return;
        }

        int pos = new Random().nextInt(r - l + 1) + l;
        Utility.exchange(arr, l, pos);
        Comparable v = arr[l];
        int lt = l;//arr[l+1 ... lt] <v
        int gt = r + 1; //arr[gt ... r]>v
        int i = l + 1; //arr[lt+1,i) == v
        while (i < gt) {
            if (Utility.less(arr[i], v)) {
                Utility.exchange(arr, i, lt + 1);
                lt++;
                i++;
            } else if (Utility.less(v, arr[i])) {
                Utility.exchange(arr, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }
        Utility.exchange(arr, l, lt);
        quickSort3Ways(arr, l, lt - 1);
        quickSort3Ways(arr, gt, r);
    }

    private static void quickSort2(Comparable[] arr, int l, int r) {
        if (r - l <= 14) {
            Insertion.sort(arr, l, r);
            return;
        }
        int p = partition2(arr, l, r);
        quickSort2(arr, l, p - 1);
        quickSort2(arr, p + 1, r);
    }

    private static int partition2(Comparable[] arr, int l, int r) {

        int pos = new Random().nextInt(r - l + 1) + l;
        Utility.exchange(arr, l, pos);
        Comparable v = arr[l];
        int i = l + 1;
        int j = r;
        while (true) {
            while (Utility.less(arr[i], v) && i <= r) i++;
            while (Utility.less(v, arr[j]) && j >= l + 1) j--;
            if (i >= j) break;
            Utility.exchange(arr, i, j);
            i++;
            j--;
        }
        Utility.exchange(arr, j, l);
        return j;

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

        int pos = new Random().nextInt(r - l + 1) + l;
        Utility.exchange(arr, l, pos);
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
