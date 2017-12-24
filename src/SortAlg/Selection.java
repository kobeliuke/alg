package SortAlg;

import util.Utility;

public class Selection {
    public static void sort(Comparable[] arr) {

        int size = arr.length;
        if (size < 2)
            return;

        for (int index = 0; index < size; index++) {

            int minIndex = index;
            for (int i = index + 1; i < size; i++) {
                if (Utility.less(arr[i], arr[minIndex])) {
                    minIndex = i;
                }
            }
            Utility.exchange(arr, index, minIndex);
        }
    }
}
