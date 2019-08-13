package sort;

import java.util.Arrays;

public class HeapSort5 {

    public static void main(String[] args) {
        HeapSort5 hs = new HeapSort5();
        int[] tree = {5, 8, 1, 9, 2, 3, 7, 6, 4};
        hs.heapSort(tree);
        System.out.println(Arrays.toString(tree));
    }

    void heapSort(int[] tree){
        buildHeap(tree, tree.length);
        for(int i = tree.length - 1; i >= 0; i--){
            swap(tree, 0, i);
            heapify(tree, i, 0);
        }
    }

    void buildHeap(int[] tree, int n) {
        int parent = (n - 1 - 1) / 2;
        for (int i = parent; i >= 0; i--) {
            heapify(tree, n, i);
        }
    }


    private void heapify(int[] tree, int n, int i) {
        if (i >= n) {
            return;
        }
        int c1 = i * 2 + 1;
        int c2 = i * 2 + 2;
        int max = i;

        if (c1 < n && tree[max] < tree[c1]) {
            max = c1;
        }
        if (c2 < n && tree[max] < tree[c2]) {
            max = c2;
        }
        if (max != i) {
            swap(tree, max, i);
            heapify(tree, n, max);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
