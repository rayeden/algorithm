package leetcode.sum;

/**
 * @author BG289522
 * @createTime 2019/7/23
 * @description
 */
public class ArrayMaxPathSum {

    public static void main(String[] args) {
        ArrayMaxPathSum am = new ArrayMaxPathSum();
        int[] arr = {1, 4, -5, 2, -5, 3, 6};
        System.out.println(am.maxPathSum(arr));
    }

    public int maxPathSum(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (sum < 0) {
                sum = arr[i];
            } else {
                sum = Math.max(sum + arr[i], arr[i]);
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
