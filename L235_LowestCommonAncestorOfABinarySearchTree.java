package LeetCode;

import java.util.LinkedList;
import java.util.Stack;

public class L235_LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {//返回最低公共父节点，不是公共序列
        if(p.val<root.val&&q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);//在根节点左侧
        } else if(p.val>root.val&&q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);//在根节点右侧
        }
        else
            return root;//在根节点两侧
    }
    public static void main(String[] args){
        Integer[] nums={6,2,8,0,4,7,9,null,null,3,5};
        Tree tree=new Tree();
        TreeNode root=tree.buildTree(nums);
        //tree.printTree(root);
        L235_LowestCommonAncestorOfABinarySearchTree l235=new L235_LowestCommonAncestorOfABinarySearchTree();
        TreeNode p=new TreeNode(2);
        TreeNode q=new TreeNode(4);
        System.out.println(l235.lowestCommonAncestor(root,p,q).val);
    }
}