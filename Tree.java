package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    public boolean isPowerSumOf2(int num){
        int pow=0;
        while(num>0){
            num-=Math.pow(2,pow);//Math.pow(a,b)，a的b次方
            //System.out.println(num);
            pow++;
        }
        if(num==0)
            return true;
        else
            return false;
    }
    public TreeNode makeBinaryTreeByArray(Integer[] array,int index){
        if(index<array.length){
            TreeNode t=new TreeNode(array[index]);
            array[index]=0;
            t.left=makeBinaryTreeByArray(array,index*2+1);
            t.right=makeBinaryTreeByArray(array,index*2+2);
            return t;
        }else
            return null;
    }
    public TreeNode Tree(Integer[] array){
        return makeBinaryTreeByArray(array,0);
    }
    public TreeNode buildTree(Integer[] array){
        return makeBinaryTreeByArray(array,0);
    }
    public void printTree(TreeNode root){
        int count=0;
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            if(treeNode.left!=null){
                queue.offer(treeNode.left);
            }
            if(treeNode.right!=null){
                queue.offer(treeNode.right);
            }
            System.out.print(treeNode.val+"\t");
            count++;
            if(isPowerSumOf2(count))
                System.out.println();
        }
    }
/*    public static void main(String[] args){
        Tree tree=new Tree();
        System.out.println(tree.isPowerSumOf2(4));
    }*/
}
