package LeetCode;

import java.util.*;
import java.util.logging.Level;

/*
广度优先搜索，
同一层的进栈
同一层从左向右加入链表
 */
public class L107_BinaryTreeLevelOrderTraversalII {
    /**
     * 采用递归的方式创建一颗二叉树
     * 传入的是二叉树的数组表示法
     * 构造后是二叉树的二叉链表表示法
     */
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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<Integer> levelList=new ArrayList<Integer>();
        Stack<List<Integer>> levellistStack=new Stack<List<Integer>>();
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        int curCount=1;//记录当前层节点数
        int nextCount=0;//记录下一层节点数
        int outCount=0;//记录出队列节点数
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            levelList.add(node.val);
            outCount++;
            if(node.left!=null){
                queue.offer(node.left);
                //levelList.add(node.left.val);//视角从子节点加入转换为当前节点输出，
                nextCount++;
            }
            if(node.right!=null){
                queue.offer(node.right);
                //levelList.add(node.right.val);
                nextCount++;
            }
            if(outCount==curCount)//当前层全部出队列
            {
                if(!levelList.isEmpty())
                    levellistStack.push(levelList);
                levelList=new ArrayList<Integer>();
                curCount=nextCount;
                nextCount=0;
                outCount=0;
            }
        }
        while(!levellistStack.isEmpty()){
            result.add(levellistStack.pop());
        }
        return result;
    }
    /**
     * 广度优先遍历
     * 采用非递归实现
     * 需要辅助数据结构：队列
     */
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
        L107_BinaryTreeLevelOrderTraversalII l107=new L107_BinaryTreeLevelOrderTraversalII();
        Integer[] values={3,9,20,null,null,15,7};
        //Integer[] values={1};
        //Integer[] values={1,2,3,4,5};
        //Integer[] values={1,2,3,4,5,6,7};
        TreeNode root=l107.makeBinaryTreeByArray(values,0);
        l107.levelOrderTraversal(root);
        List<List<Integer>> res=l107.levelOrderBottom(root);
        System.out.println(res.toString());
    }
}