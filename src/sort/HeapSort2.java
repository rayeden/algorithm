package sort;

import java.util.Arrays;

/**
 * @author Sesame
 * @createTime 2019/7/4
 * @description
 */
public class HeapSort2 {

    public static void main(String[] args) {
        HeapSort2 hs = new HeapSort2();
        int[] array = {4, 10, 3, 5, 1, 2, 9, 32, 53, 11, 15, 7};
        int[] res = new int[array.length];
        hs.heapSort(array, array.length - 1, res);
        System.out.println(Arrays.toString(res));
    }

    private void heapSort(int[] array, int n, int[] result) {
        buildSort(array, n);
        for (int i = n; i >= 0; i--) {
            result[i] = array[0];
            swap(array, i, 0);
            heapify(array, i - 1, 0);
//            buildSort(array, i - 1);
        }
    }

    private void buildSort(int[] array, int n) {
        int p = (n - 1) / 2;
        for (int i = p; i >= 0; i--) {
            heapify(array, n, i);
        }
    }

    private void heapify(int[] array, int n, int i) {
        if (i > n) {
            return;
        }
        int max = i;
        int c1 = i * 2 + 1;
        int c2 = i * 2 + 2;
        if (c1 <= n && array[c1] > array[max]) {
            max = c1;
        }
        if (c2 <= n && array[c2] > array[max]) {
            max = c2;
        }
        if (max != i) {
            swap(array, i, max);
            heapify(array, n, max);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
