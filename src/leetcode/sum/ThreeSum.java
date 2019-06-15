package leetcode.sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xhtc
 * @createTime 2019/6/14
 * @description O(nlogn)
 * 如果和TwoSum一样用map的话，最佳是O(n2)复杂度。如果要求返回的是具体数值，可以先排序，再用两头指针的方法查找。
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum s = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] res = s.threeSum(nums, 3);
        System.out.println(Arrays.toString(res));

        int[] res2 = s.threeSum2(nums, 3);
        System.out.println(Arrays.toString(res2));
    }

    /**
     * 返回下标
     *
     * @param nums
     * @param target
     * @return
     */
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

    /**
     * 返回具体数值
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] threeSum2(int[] nums, int target) {
        //排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                if (nums[start] + nums[end] > diff) {
                    end--;
                } else if (nums[start] + nums[end] < diff) {
                    start++;
                } else {
                    return new int[]{nums[i], nums[start], nums[end]};
                }
            }
        }
        return new int[]{};
    }


}
