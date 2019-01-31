package LeetCode;
import java.util.LinkedList;
import java.util.List;

public class L257_BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {//解答里每次都加入answer参数是为了保证对同一个链表操作
        List<String> answer= new LinkedList<String>();
        if(root==null)
            return answer;
        if(root.left==null&&root.right==null){
            answer.add(Integer.toString(root.val));
            return answer;
        }
        for(String left:binaryTreePaths(root.left)){
            answer.add(root.val+"->"+left);
        }
        for(String right:binaryTreePaths(root.left)){
            answer.add(root.val+"->"+right);
        }
        return answer;
    }
    public static void main(String[] args){
        L257_BinaryTreePaths l257=new L257_BinaryTreePaths();
        Integer[] nums={1,2,3,null,5};
        Tree tree=new Tree();
        TreeNode root=tree.buildTree(nums);
        //tree.printTree(root);
        //tree.DFS(root);
        List<String> answer =l257.binaryTreePaths(root);
        System.out.println(answer);
    }
}