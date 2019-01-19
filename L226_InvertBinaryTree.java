package LeetCode;

public class L226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        TreeNode left=root.right;//直接交换左右子节点
        TreeNode right=root.left;
        root.left=invertTree(left);//root的子节点与翻转后的节点建立关联
        root.right=invertTree(right);
        return root;
    }
}
