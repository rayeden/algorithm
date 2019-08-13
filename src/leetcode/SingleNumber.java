package leetcode;

import java.util.Arrays;

/**
 * @author Sesame
 * @createTime 2019/7/20
 * @description
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        SingleNumber sn = new SingleNumber();
        System.out.println(Arrays.toString(sn.singleNumber(nums)));
    }

    public int[] singleNumber(int[] nums) {
        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }
        int index = 1;
        while ((xor & index) == 0) {
            index <<= 1;
        }
        int num1 = 0, num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & index) == 0) {
                num1 ^= nums[i];
            } else {
                num2 ^= nums[i];
            }
        }
        return new int[]{num1, num2};
    }

}
