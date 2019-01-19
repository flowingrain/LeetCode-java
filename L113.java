package LeetCode;
/*
113 Path Sum 2
 */

//import javax.swing.tree.TreeNode;
/*
编译通过版本
列表的循环添加，注意添加完一个数之后要移除这个数
class Solution {
    List<List<Integer>> results;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        results = new ArrayList<List<Integer>>();
        if (root == null)
            return results;

        ArrayList<Integer> result = new ArrayList<Integer>();
        pathSum(root, 0, sum, result);

        return results;
    }

    public void pathSum(TreeNode root, int res, int sum, ArrayList<Integer> result) {
        if (root == null)
            return;
        else if (root.left == null && root.right == null) {
            if (res + root.val == sum) {
                result.add(root.val);
                results.add(new ArrayList<Integer>(result));
                result.remove(result.size()-1);
            }
        } else {
            result.add(root.val);
            pathSum(root.left, res + root.val, sum, result);
            pathSum(root.right, res + root.val, sum, result);
            result.remove(result.size()-1);
        }
    }
}
 */
import java.util.*;

class L113 {
    //两个全局变量
    ArrayList<List<Integer>> paths= new ArrayList<List<Integer>>();
    ArrayList<Integer> path=new ArrayList<Integer>();
    public  void DFS(TreeNode root,int sum,ArrayList<Integer> path){
        //System.out.println(sum);//存在输入为负的情况
        if(root.left==null && root.right==null)//root为叶子节点，当前路径和为sum;原来对是叶子节点但和不为sum的情况考虑不足
        {
            if(sum==0)
            {
                path.add(root.val);
                paths.add(new ArrayList<Integer>(path));
                path.remove(path.size()-1);//移除刚加上的节点
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null){
            return paths;
        }
        //path.add(root.val);
        DFS(root,sum-root.val,path);
        return paths;
    }
}