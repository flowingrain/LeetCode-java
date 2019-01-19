package LeetCode;

import java.util.*;

public class L110_BalancedBinaryTree {
    public TreeNode makeBinaryTreeByArray(Integer[] array,int index){
        if(index<array.length&&array[index]!=null){
            int value=array[index];
            TreeNode t=new TreeNode(value);
            array[index]=0;
            t.left=makeBinaryTreeByArray(array,index*2+1);
            t.right=makeBinaryTreeByArray(array,index*2+2);
            return t;
        }else
            return null;
    }
    public int maxDepth(TreeNode root) {//获取深度的函数单独拆出
        if(root==null)
            return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        return (Math.abs(maxDepth(root.left)-maxDepth(root.right))<=1)&&isBalanced(root.left)&&isBalanced(root.right);
    }

    public void levelOrderTraversal(TreeNode root){//广度优先搜索+分层.注意非全二叉树插入空节点
        if(root==null){
            return;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        int curCount=1;//记录当前层节点数
        int nextCount=0;//记录下一层节点数
        int outCount=0;//记录出队列节点数
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            outCount++;
            if(node!=null){
                System.out.print(node.val);//空节点无值打印，直接输出下方的tab
                queue.offer(node.left);
                nextCount++;
                queue.offer(node.right);
                nextCount++;
            }
            System.out.print("\t");
            if(outCount==curCount)//当前层全部出队列
            {
                System.out.println();
                curCount=nextCount;
                nextCount=0;
                outCount=0;
            }
        }
    }
    public static void main(String[] args){
        L110_BalancedBinaryTree l110=new L110_BalancedBinaryTree();
        Integer[] nums={3,9,20,null,null,15,7};
        //Integer[] nums={1,2,2,3,3,null,null,4,4};
        TreeNode root=l110.makeBinaryTreeByArray(nums,0);
        //l110.levelOrderTraversal(root);
        System.out.println(l110.isBalanced(root));
    }
}