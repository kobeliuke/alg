import heap.MaxHeap;
import org.junit.Test;
import util.GenerateUtil;

import java.util.Arrays;

public class HeapTest {

    @Test
    public void test1() {
        MaxHeap heap = new MaxHeap(100);
        System.out.println(heap.size());
        System.out.println(heap.isEmpty());
    }

    @Test
    public void maxHeapTest1() {
        MaxHeap heap = new MaxHeap(100);
        Integer arr[] = GenerateUtil.genRanNumArr(15, 20);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        for (int i = 0; i < arr.length; i++) {
            heap.insert(arr[i]);
        }
        System.out.println();
        heap.showHeap();

    }

    @Test
    public void maxHeapTest2() {
        MaxHeap heap = new MaxHeap(100);
        Integer arr[] = GenerateUtil.genRanNumArr(15, 20);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        for (int i = 0; i < arr.length; i++) {
            heap.insert(arr[i]);
        }
        System.out.println();
        System.out.println("get: " + heap.extractMax());
        System.out.println();
        heap.showHeap();
    }
}
