package LeetCode;

import java.util.LinkedList;

public class L700_SearchInABinarySearchTree {
   public TreeNode searchBST(TreeNode root, int val) {
        if(root==null||root.val==val)
            return root;
        LinkedList<TreeNode> stack=new LinkedList<TreeNode>();
        stack.addLast(root);
        while(!stack.isEmpty()){
            TreeNode tn=stack.removeLast();
            if(tn==null||tn.val==val)
                return tn;
            else if(tn.val>val)
                stack.addLast(tn.left);
            else
                stack.addLast(tn.right);
        }
        return null;
    }
   /*public TreeNode searchBST(TreeNode root, int val) {//是二叉搜索树，有序的
       if(root==null||root.val==val)
           return root;
       else if(root.val<val)
           return searchBST(root.right,val);
       else
           return searchBST(root.left,val);
   }*/

    public static void main(String[] args){
        L700_SearchInABinarySearchTree l700=new L700_SearchInABinarySearchTree();
        Integer[] nums={4,2,7,1,3};
        Tree tree=new Tree();
        TreeNode root=tree.buildTree(nums);
        tree.printTree(root);
        //TreeNode tn =l700.searchBST(root,5);
        TreeNode tn =l700.searchBST(root,2);
        tree.printTree(tn);
    }
}
