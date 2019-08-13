package sort.heapsort;

import java.util.Arrays;

/**
 * @author Sesame
 * @createTime 2019/7/5
 * @description
 */
public class HeapSort3 {

    public static void main(String[] args) {
        int[] array = {4, 10, 3, 5, 1, 2, 9, 32, 53, 11, 15, 7};
        int[] res = new int[array.length];
        HeapSort3 hs3 = new HeapSort3();
        hs3.heapSort(array, array.length, res);
        System.out.println(Arrays.toString(res));
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void heapify(int[] array, int n, int i) {
        if (i >= n) {
            return;
        }
        int max = i, c1 = i * 2 + 1, c2 = i * 2 + 2;
        if (c1 < n && array[c1] > array[max]) {
            max = c1;
        }
        if (c2 < n && array[c2] > array[max]) {
            max = c2;
        }
        if (max != i) {
            swap(array, i, max);
            heapify(array, n, max);
        }
    }

    private void buildHeap(int[] array, int n) {
        if (n <= 0) {
            return;
        }
        int p = (n - 1 - 1) / 2;
        for (int i = p; i >= 0; i--) {
            heapify(array, n, i);
        }
    }

    private void heapSort(int[] array, int n, int[] res) {
        buildHeap(array, n);
        for (int i = n - 1; i >= 0; i--) {
            res[i] = array[0];
            swap(array, i, 0);
            heapify(array, i, 0);
        }
    }
}
