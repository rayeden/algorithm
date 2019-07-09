package leetcode;

/**
 * @author xhtc
 * @createTime 2019/6/15
 * @description 空树也是一颗二叉排序树
 */
public class ValidateBST {

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{3, 1, 5, null, 2};
        Integer[] nums2 = new Integer[]{5, 1, 4, null, null, 3, 6};
        ValidateBST v = new ValidateBST();
        System.out.println(v.validate(nums));
        System.out.println(v.validate(nums2));
        System.out.println("-------");

        System.out.println(v.validate2(nums, 0));
        System.out.println(v.validate2(nums2, 2));
    }

    public boolean validate(Integer[] nums) {
        //空树也是二叉排序树
        if(null == nums || nums.length == 0){
            return true;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!validate(nums, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean validate(Integer[] nums, int index) {
        int leftIndex = index * 2 + 1;
        int rightIndex = leftIndex + 1;
        if (index >= nums.length || leftIndex >= nums.length || rightIndex >= nums.length) {
            return true;
        }
        if (nums[leftIndex] != null && nums[index] < nums[leftIndex]) {
            return false;
        }
        if (nums[rightIndex] != null && nums[index] > nums[rightIndex]) {
            return false;
        }
        return true;
    }

    public boolean validate2(Integer[] nums, int index) {
        int leftIndex = index * 2 + 1;
        int rightIndex = leftIndex + 1;
        if (index >= nums.length) {
            return true;
        }
        if(leftIndex < nums.length) {
            return nums[leftIndex] == null || nums[index] > nums[leftIndex];
        }
        if(rightIndex < nums.length){
            return nums[rightIndex] == null || nums[index] < nums[rightIndex];
        }
        return validate2(nums, leftIndex) && validate2(nums, rightIndex);
    }


}
