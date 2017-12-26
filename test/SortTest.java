import SortAlg.Insertion;
import SortAlg.Merge;
import SortAlg.Quick;
import org.junit.Test;
import util.GenerateUtil;

import java.util.Arrays;

public class SortTest {

    @Test
    public void positionTest() {
        int l = 100;
        int r = 300;

        int m = (l + r) / 2;

        //防止int过大溢出求终点的方法
        int m2 = l + (r - l) / 2;

        System.out.println(m);
        System.out.println(m2);
    }

    @Test
    public void mergeSortTest() {
        Integer[] arr = GenerateUtil.genRanNumArr(11, 50);
        Merge.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }

    @Test
    public void mergeImproveTest(){
        Integer[] arr = GenerateUtil.genRanNumArr(11, 50);

        Merge.sortImprove(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }


    @Test
    public void mergeBtTest(){
        Integer[] arr = GenerateUtil.genRanNumArr(11, 50);

        Merge.sortBT(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }

    @Test
    public void quickSortTest(){
        Integer[] arr = GenerateUtil.genRanNumArr(11, 50);

        Quick.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }

    @Test
    public void quickSortImproveTest(){
        Integer[] arr = GenerateUtil.genRanNumArr(11, 50);

        Quick.sortImprove(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }

    @Test
    public void performanceQuick(){
        Integer[] arr = GenerateUtil.genRanNumArr(500003, 50);
        //Integer[] arr = GenerateUtil.genNearlyOrderArr(500009,200);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);

        long start = System.currentTimeMillis();
        Merge.sortImprove(arr);
        long end = System.currentTimeMillis();
        double duration = (end - start) / 1000d;
        System.out.print("merge: " + duration + "s\n");

        start = System.currentTimeMillis();
        Quick.sort(arr2);
        end = System.currentTimeMillis();
        duration = (end - start) / 1000d;

        System.out.println("quick: " + duration + "s");

        start = System.currentTimeMillis();
        Quick.sortImprove(arr3);
        end = System.currentTimeMillis();
        duration = (end - start) / 1000d;

        System.out.println("quick improve: " + duration + "s");
    }

    @Test
    public void performanceCompare() {
        //Integer[] arr = GenerateUtil.genNearlyOrderArr(50000,200);
        Integer[] arr = GenerateUtil.genRanNumArr(50000, 50000);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr,arr.length);
        Integer[] arr4 = Arrays.copyOf(arr,arr.length);

        long start = System.currentTimeMillis();
        Merge.sort(arr);
        long end = System.currentTimeMillis();
        double duration = (end - start) / 1000d;
        System.out.print("merge: " + duration + "s\n");

        start = System.currentTimeMillis();
        Merge.sortImprove(arr2);
        end = System.currentTimeMillis();
        duration = (end - start) / 1000d;

        System.out.println("merge improve: " + duration + "s");

        start = System.currentTimeMillis();
        Merge.sortBT(arr3);
        end = System.currentTimeMillis();
        duration = (end - start) / 1000d;

        System.out.println("merge BT: " + duration + "s");

        start = System.currentTimeMillis();
        Insertion.sort(arr4);
        end = System.currentTimeMillis();
        duration = (end - start) / 1000d;

        System.out.println("insertion: " + duration + "s");
    }
}
