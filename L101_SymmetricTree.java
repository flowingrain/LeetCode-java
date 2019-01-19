package LeetCode;

public class L101_SymmetricTree {
    public boolean isAlike(TreeNode p, TreeNode q) {//把一棵树的对称转化为两棵树的相似
        if(p==null&&q==null)
            return true;
        if((p==null&&q!=null)||(p!=null&&q==null)||(p.val!=q.val))
            return false;
        return isAlike(p.left,q.right)&&isAlike(p.right,q.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return isAlike(root.left,root.right);
    }
}