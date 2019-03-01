package LeetCode;

import java.util.*;

public class L144_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new LinkedList<Integer>();
        if(root==null)
            return result;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp=stack.pop();
            result.add(temp.val);
            //System.out.println(temp.val);
            if(temp.right!=null){//先往栈中压入右节点，再压左节点，这样出栈就是先左节点后右节点了。
                //System.out.println("right"+temp.right.val);
                stack.push(temp.right);
            }
            if(temp.left!=null){
                //System.out.println("left"+temp.left.val);
                stack.push(temp.left);
            }

        }
        return result;
    }
    public static void main(String[] args){
        L144_BinaryTreePreorderTraversal l144=new L144_BinaryTreePreorderTraversal();
        Integer[] nums={1,null,2,3};
        Tree tree=new Tree();
        TreeNode head=tree.buildTree(nums);
        tree.printTree(head);//建的树有问题。
        List<Integer> list=l144.preorderTraversal(head);
        Iterator<Integer> it=list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
