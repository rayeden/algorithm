package leetcode;

import leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Sesame
 * @createTime 2019/7/18
 * @description
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (null == root) {
            return lists;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root);
        List<Integer> list = new ArrayList<>();
        while (!q1.isEmpty()) {
            TreeNode node = q1.poll();
            list.add(node.val);
            if (node.left != null) {
                q2.add(node.left);
            }
            if (node.right != null) {
                q2.add(node.right);
            }
            if (q1.isEmpty()) {
                lists.add(list);
                list = new ArrayList<>();
                while (!q2.isEmpty()) {
                    q1.add(q2.poll());
                }
            }
        }
        return lists;
    }
}
