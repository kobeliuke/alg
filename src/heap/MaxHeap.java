package heap;

import util.Utility;

public class MaxHeap {

    private Comparable[] data;
    private int count;

    public MaxHeap(int maxCapacity) {
        //数组从1 开始， 0 空缺
        data = new Comparable[maxCapacity + 1];
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public int insert(Comparable item) {
        if (count + 1 > data.length) {
            return -1;
        }
        data[count + 1] = item;
        count++;
        shiftUp(count);
        return count;
    }

    public Comparable extractMax() {
        if (count < 1) {
            return null;
        }
        Comparable result = data[1];
        data[1] = data[count];
        count--;
        shiftDown(1);
        return result;

    }

    public void showHeap() {
        for (int i = 1; i <= count; i++) {
            System.out.print(data[i] + " ");
        }
    }

    private void shiftUp(int index) {
        Comparable temp = data[index];

        while (index > 1 && Utility.less(data[index / 2], temp)) {
            data[index] = data[index / 2];
            index /= 2;
        }
        data[index] = temp;
    }

    private void shiftDown(int index) {
        Comparable temp = data[index];
        while (2 * index <= count) {
            int child = 2 * index;
            if (child + 1 <= count && Utility.less(data[child], data[child + 1])) {
                child++;
            }
            if (Utility.less(data[child], temp)) {
                break;
            } else {
                data[index] = data[child];
                index = child;
            }
        }
        data[index] = temp;
    }

}
