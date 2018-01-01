package simpleSort;

import util.Utility;

public class Shell {

    public static void sort(Comparable[] arr, int h) {
        int size = arr.length;
        if (size < 2) {
            return;
        }

        while (h >= 1) {
            for (int i = h; i < size; i++) {
                Comparable temp = arr[i];
                int j;      //j> h-1 同样
                for (j = i; j >= h && Utility.less(temp, arr[j - h]); j -= h) {
                    arr[j] = arr[j - h];
                }
                arr[j] = temp;
            }
            h = h / 2;
        }
    }
}
