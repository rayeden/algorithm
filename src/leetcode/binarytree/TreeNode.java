package leetcode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xhtc
 * @createTime 2019/6/16
 * @description
 */
public class TreeNode {

    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    private Queue<Integer> queue = new LinkedList<>();


    public TreeNode create(Integer[] nums) {
        if (null == nums || nums.length == 0) {
            return null;
        }
        int index = 0;
        queue.add(nums[0]);
        TreeNode root = null;
        while (index < nums.length && !queue.isEmpty()) {


        }
        return null;

    }

}
