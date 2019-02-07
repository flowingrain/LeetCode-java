package LeetCode;

public class L701_InsertIntoABinarySearchTree {
   public TreeNode insertIntoBST(TreeNode root, int val) {//是二叉搜索树，有序的
      /* if(root==null)
           root=new TreeNode(val);*/
        if(val<root.val){
           if(root.left==null)
                root.left=new TreeNode(val);
           else
                insertIntoBST(root.left,val);
        }else{
           if(root.right==null)
               root.right=new TreeNode(val);
           else
               insertIntoBST(root.right,val);
        }
        return root;
   }
    public static void main(String[] args){
        L701_InsertIntoABinarySearchTree l701=new L701_InsertIntoABinarySearchTree();
        //Integer[] nums={4,2,7,1,3};
        //[61,46,66,43,null,null,null,39,null,null,null]
        //88
        Integer[] nums={61,46,66,43,null,null,null,39,null,null,null};
        Tree tree=new Tree();
        TreeNode root=tree.buildTree(nums);
        tree.printTree(root);
        TreeNode tn =l701.insertIntoBST(root,88);
        tree.printTree(tn);
    }
}