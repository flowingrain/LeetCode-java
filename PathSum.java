package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    //ArrayList<List<Integer>> paths= new ArrayList<List<Integer>>();
    ArrayList<Integer> path=new ArrayList<Integer>();
    boolean hasPath=false;
    public  void DFS(TreeNode root,int sum,ArrayList<Integer> path){
        //System.out.println(sum);
        if(root.left==null && root.right==null)//root为叶子节点，当前路径和为sum;原来对是叶子节点但和不为sum的情况考虑不足
        {
            if(sum==0)
            {
                //path.add(root.val);
                //paths.add(new ArrayList<Integer>(path));
                hasPath=true;
                return;
                //path.remove(path.size()-1);//移除刚加上的节点
            }
        }else{
            path.add(root.val);//不加else的话，这句始终会执行
            if(root.left!=null)
                DFS(root.left,sum-root.left.val,path);
            //执行的过程中就把加入的子节点去掉了
            if(root.right!=null)
                DFS(root.right,sum-root.right.val,path);
            path.remove(path.size()-1);//移除加入的父节点
        }
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        //path.add(root.val);
        DFS(root,sum-root.val,path);
        //return paths;
        return hasPath;
    }
}
