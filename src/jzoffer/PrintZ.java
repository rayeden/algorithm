package jzoffer;

import leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Sesame
 * @createTime 2019/6/26
 * @description 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * 用两个栈实现
 */
public class PrintZ {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (null == pRoot) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        stack1.push(pRoot);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                list.add(node.val);
                if (node.left != null) {
                    stack2.push(node.left);
                }
                if (node.right != null) {
                    stack2.push(node.right);
                }
                if (stack1.isEmpty()) {
                    lists.add(new ArrayList<>(list));
                    list.clear();
                }
            }
            while (!stack2.isEmpty()) {
                TreeNode node = stack2.pop();
                list.add(node.val);
                if (node.right != null) {
                    stack1.push(node.right);
                }
                if (node.left != null) {
                    stack1.push(node.left);
                }
                if (stack2.isEmpty()) {
                    lists.add(new ArrayList<>(list));
                    list.clear();
                }
            }
        }
        return lists;
    }

}
