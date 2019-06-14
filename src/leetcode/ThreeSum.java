package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xhtc
 * @createTime 2019/6/14
 * @description O(nlogn)
 * 如果和TwoSum一样用map的话，最佳是O(n2)复杂度
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum s = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] res = s.threeSum(nums, 3);
        System.out.println(Arrays.toString(res));
    }

    public int[] threeSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            int diff = target - nums[i];
            for (int j = 0; j < nums.length && j != i; j++) {
                int diff2 = diff - nums[j];
                if (map.containsKey(diff2) && map.get(diff2) != j) {
                    return new int[]{i, j, map.get(diff2)};
                }
                map.put(nums[j], j);
            }
        }
        return new int[]{};
    }
}
