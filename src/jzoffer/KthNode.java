package jzoffer;

import leetcode.binarytree.TreeNode;

/**
 * @author xhtc
 * @createTime 2019/6/25
 * @description 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */
public class KthNode {

    public TreeNode KthNode(TreeNode pRoot, int k) {
        TreeNode[] result = new TreeNode[1];
        int[] count = {0};
        preOrder(pRoot, k, count, result);
        return result[0];
    }

    //先序遍历
    private void preOrder(TreeNode pRoot, int k, int[] count, TreeNode[] result) {
        if (null == pRoot || result[0] != null) {
            return;
        }
        preOrder(pRoot.left, k, count, result);
        if (++count[0] == k) {
            result[0] = pRoot;
            return;
        }
        preOrder(pRoot.right, k, count, result);
    }
}
