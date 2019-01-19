package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class L108_ConvertSortedArray2BinarySearchTree {
    public TreeNode makeBinaryTreeByArray(int[] nums,int low,int high){
        if(low<=high){
            int mid=(high+low)/2;
            TreeNode root=new TreeNode(nums[mid]);
            //System.out.println(root.val);
            root.left=makeBinaryTreeByArray(nums,low,mid-1);
            root.right=makeBinaryTreeByArray(nums,mid+1,high);
            return root;
        }
        else
            return null;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeBinaryTreeByArray(nums,0,nums.length-1);
    }
    public void levelOrderTraversal(TreeNode root){//广度优先搜索+分层
        if(root==null){
            //System.out.println("empty tree");
            return;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        int curCount=1;//记录当前层节点数
        int nextCount=0;//记录下一层节点数
        int outCount=0;//记录出队列节点数
        while(!queue.isEmpty()){
            TreeNode node=queue.remove();
            outCount++;
            System.out.print(node.val+"\t");
            if(node.left!=null){
                queue.add(node.left);
                nextCount++;
            }
            if(node.right!=null){
                queue.add(node.right);
                nextCount++;
            }
            if(outCount==curCount)//当前层全部出队列
            {
                System.out.println();
                curCount=nextCount;
                outCount=0;
            }
        }
        System.out.println("");
    }
    public static void main(String[] args){
        int[] nums={-10,-3,0,5,9};
        L108_ConvertSortedArray2BinarySearchTree l108=new L108_ConvertSortedArray2BinarySearchTree();
        TreeNode root=l108.sortedArrayToBST(nums);
        l108.levelOrderTraversal(root);
    }
}