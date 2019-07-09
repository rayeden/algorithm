package jzoffer;

import leetcode.binarytree.TreeNode;

/**
 * @author Sesame
 * @createTime 2019/6/26
 * @description
 */
public class SeAndDeseTree {

    public static void main(String[] args) {
        SeAndDeseTree sd = new SeAndDeseTree();
        String str = "8,6,10,5,7,9,11,";
        TreeNode root = sd.Deserialize(str);
        String res = sd.Serialize(root);
        System.out.println(res);
    }


    String Serialize(TreeNode root) {
        if (null == root) {
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        SerializeCore(root, sb);
        return sb.toString();
    }

    void SerializeCore(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        } else {
            sb.append(String.valueOf(node.val)).append(",");
        }
        SerializeCore(node.left, sb);
        SerializeCore(node.right, sb);
    }

    TreeNode Deserialize(String str) {
        if(null == str || str.length() == 0){
            return null;
        }
        String[] ss = str.split(",");
        return deserializeCore(ss, -1);
    }

    TreeNode deserializeCore(String[] ss, int index){
        index ++;
        if(index < ss.length && !"#".equals(ss[index])){
            TreeNode node = new TreeNode(Integer.valueOf(ss[index]));
            node.left = deserializeCore(ss, index);
            node.left = deserializeCore(ss, index);
            return node;
        }
        return null;
    }
}
