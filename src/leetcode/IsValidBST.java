package leetcode;

import leetcode.binarytree.TreeNode;

import java.util.Stack;

/**
 * @author Sesame
 * @createTime 2019/7/20
 * @description
 */
public class IsValidBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);
        IsValidBST ivb = new IsValidBST();
        System.out.println(ivb.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack =  new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(prev != null){
                if(prev.val >= cur.val){
                    return false;
                }
            }
            prev =cur;
            cur = cur.right;
        }
        return true;
    }

}
