import simpleSort.Insertion;
import simpleSort.Selection;
import simpleSort.Shell;
import org.junit.Test;
import util.GenerateUtil;

import java.util.Arrays;

public class SimpleSortTest {

    @Test
    public void genRanNumArrTest() {
        Integer[] arr = GenerateUtil.genRanNumArr(100,1000);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "    ");

            if(((i+1)%10) == 0 ){
                System.out.print("\n");
            }
        }
    }

    @Test
    public void genRanStrArrTest(){
        String[] arr = GenerateUtil.genRanStrArr(100);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "    ");

            if(((i+1)%10) == 0 ){
                System.out.print("\n");
            }
        }
    }
    @Test
    public void selectionSortTest() {
        Integer[] arr = GenerateUtil.genRanNumArr(50,50);
        Selection.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    @Test
    public void insertionSortTest(){
        Integer[] arr = GenerateUtil.genRanNumArr(50,50);
        Insertion.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");


    }

    @Test
    public void shellSortTest(){
        Integer[] arr = GenerateUtil.genRanNumArr(11,50);
        Shell.sort(arr,3);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }

    @Test
    public void performanceCompareTest(){
        //Integer[] arr = GenerateUtil.genRanNumArr(100000,10);
        Integer[] arr = GenerateUtil.genRanNumArr(50000,50000);
        Integer[] arr2 = Arrays.copyOf(arr,arr.length);
        Integer[] arr3 = Arrays.copyOf(arr,arr.length);
        long start = System.currentTimeMillis();
        Selection.sort(arr);
        long end = System.currentTimeMillis();
        double duration = (end -start)/1000d;
        System.out.print("selection: " + duration +"s\n");

        start = System.currentTimeMillis();
        Insertion.sort(arr2);
        end = System.currentTimeMillis();
        duration = (end - start)/1000d;

        System.out.println("insertion: " + duration +"s");
        start = System.currentTimeMillis();
        Shell.sort(arr3,6);
        end = System.currentTimeMillis();
        duration = (end - start)/1000d;

        System.out.println("shell: " + duration +"s");

    }

}
