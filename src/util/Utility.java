package util;

public class Utility {

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    /**
     * exchange the two elements in an array
     * @param arr
     * @param i
     * @param j
     */
    public static void exchange(Comparable[] arr, int i, int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
