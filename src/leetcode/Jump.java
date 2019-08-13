package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sesame
 * @createTime 2019/7/16
 * @description
 */
public class Jump {

    public static void main(String[] args) {
        Jump jp = new Jump();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jp.jump2(nums));
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.remove(list.size() - 1);
    }

    public int jump2(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        int steps = 0;
        int end = 0;
        int maxIndex = 0;
        //跳到最后一个位置的最小跳数是2
        for (int i = 0; i < nums.length - 1; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if (end == i) {
                end = maxIndex;
                steps++;
            }
            if (end >= nums.length - 1) {
                return steps;
            }
        }
        return steps;
    }

    public int jump(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        int count = 0;
        int i = 0;
        int cur = i;
        while (i < nums.length - 1) {
            int next = i;
            if (i + nums[i] >= nums.length - 1) {
                return count + 1;
            }
            for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
                if (j + nums[j] > next) {
                    next = j + nums[j];
                    cur = j;
                }
            }
            i = cur;
            count++;
        }
        return count;
    }
}
