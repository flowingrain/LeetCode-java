package LeetCode;

public class L104_MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int depth=1;
        depth+=Math.max(maxDepth(root.left),maxDepth(root.right));
        return depth;
    }
}