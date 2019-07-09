package leetcode.sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xhtc
 * @createTime 2019/6/14
 * @description O(n)
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            //每次直接去map查是否有满足条件的diff
            if (map.containsKey(diff) && map.get(diff) != i) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }

}
