package jzoffer;

/**
 * @author Sesame
 * @createTime 2019/7/2
 * @description
 */
public class InversePairs {

    public static void main(String[] args) {
        InversePairs ivp = new InversePairs();
        int[] array = {5, 4, 7, 6};
        System.out.println(ivp.inversePairs(array));
    }

    public int inversePairs(int[] array) {
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return InversePairsCore(array, copy, 0, array.length - 1);
    }

    public int InversePairsCore(int[] array, int[] copy, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = (start + end) / 2;
        int left = InversePairsCore(array, copy, start, mid - 1);
        int right = InversePairsCore(array, copy, mid, end);

        int i = mid - 1;
        int j = end;
        int count = 0;
        while (i >= 0 && j >= mid) {
            if (array[i] > array[j]) {
                count++;
                swap(array, i, j);
                copy[i] = array[i];
                copy[j] = array[j];
                i--;
            } else if (array[i] < array[j]) {
                copy[i] = array[i];
                copy[j] = array[j];
                j--;
            }
        }
        return left + right + count;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
