package simpleSort;

import util.Utility;

public class Insertion {
    public static void sort(Comparable[] arr) {

        int size = arr.length;
        if (size < 2)
            return;

        for (int i = 1; i < size; i++) {
            Comparable temp = arr[i];
            int j;
            for (j = i; j > 0 && Utility.less(temp, arr[j - 1]); j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    public static void sort(Comparable[] arr, int lIndex, int rIndex) {
        for (int i = lIndex + 1; i <= rIndex; i++) {
            Comparable temp = arr[i];
            int j;
            for (j = i; j > 0 && Utility.less(temp, arr[j - 1]); j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }
}
