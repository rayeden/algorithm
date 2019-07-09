package leetcode.sum;

import java.util.*;

/**
 * @author xhtc
 * @createTime 2019/6/14
 * @description O(n3)
 */
public class FourSum {


    public static void main(String[] args) {
        FourSum test = new FourSum();
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(test.fourSum(nums, 0));

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> lists = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            for(int j = i + 1; j < nums.length; j++){
                int diff2 = diff - nums[j];
                int start = j + 1, end = nums.length - 1;
                while(start < end){
                    if(nums[start] + nums[end] > diff2){
                        do{
                            end --;
                        }while(start < end - 1  && nums[end] == nums[end + 1]);
                    }else if(nums[start] + nums[end] < diff2){
                        do{
                            start ++;
                        }while(start + 1 < end && nums[start - 1] == nums[start]);
                    }else{
                        lists.add(Arrays.asList(nums[i], nums[j], nums[start++], nums[end--]));
                    }
                }
            }
        }
        return new ArrayList<>(lists);
    }

}
