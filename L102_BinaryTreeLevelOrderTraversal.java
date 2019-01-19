package LeetCode;

import java.util.*;

public class L102_BinaryTreeLevelOrderTraversal {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<Integer> levelList=new ArrayList<Integer>();
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
                nextCount++;
            }
            if(node.right!=null){
                queue.offer(node.right);
                nextCount++;
            }
            if(outCount==curCount)//当前层全部出队列
            {
                if(!levelList.isEmpty())
                    result.add(levelList);
                levelList=new ArrayList<Integer>();
                curCount=nextCount;
                nextCount=0;
                outCount=0;
            }
        }
        return result;
    }

    public static void main(String[] args){
        L102_BinaryTreeLevelOrderTraversal l102=new L102_BinaryTreeLevelOrderTraversal();
        Integer[] values={1,2,3,4,5,6,7};
        TreeNode root=l102.makeBinaryTreeByArray(values,0);
        List<List<Integer>> res=l102.levelOrder(root);
        System.out.println(res.toString());
    }
}