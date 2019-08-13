package sort.heapsort;

import java.util.Arrays;

/**
 * @author Sesame
 * @createTime 2019/7/4
 * @description
 */
public class HeapSort {

    void heapSort(int[] array, int n, int[] res) {
        buildHeap(array, n);
        for (int i = n - 1; i >= 0; i--) {
            res[i] = array[0];
            swap(array, i, 0);
            heapify(array, i, 0);
        }
    }

    void buildHeap(int[] array, int n) {
        int last = n - 1;
        int parent = (last - 1) / 2;
        for (int i = parent; i >= 0; i--) {
            heapify(array, n, i);
        }
    }

    void heapify(int[] array, int n, int i) {
        if (i >= n) {
            return;
        }
        int max = i;
        //计算两个字节点
        int c1 = i * 2 + 1;
        int c2 = i * 2 + 2;
        if (c1 < n && array[max] < array[c1]) {
            max = c1;
        }
        if (c2 < n && array[max] < array[c2]) {
            max = c2;
        }
        if (max != i) {
            swap(array, max, i);
            //max在需要交换的节点的位置
            heapify(array, n, max);
        }
    }

    void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        HeapSort hs = new HeapSort();
        int[] array = {4, 10, 3, 5, 1, 2};
        int[] res = new int[array.length];
        hs.heapSort(array, array.length, res);
        System.out.println(Arrays.toString(res));
    }

}
