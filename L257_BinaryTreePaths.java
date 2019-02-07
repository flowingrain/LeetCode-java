package LeetCode;
import java.util.LinkedList;
import java.util.List;

public class L257_BinaryTreePaths {
   public List<String> binaryTreePaths(TreeNode root) {//使用递归
        List<String> paths= new LinkedList<String>();
        if(root==null)
            return paths;
        if(root.left==null&&root.right==null)//根节点为叶子节点
            paths.add(String.valueOf(root.val));
        for(String path:binaryTreePaths(root.left)){
            paths.add(root.val+"->"+path);
        }
        for(String path:binaryTreePaths(root.right)){
            paths.add(root.val+"->"+path);
        }
        return paths;
    }
    public static void main(String[] args){
        L257_BinaryTreePaths l257=new L257_BinaryTreePaths();
        Integer[] nums={37,-34,-48,null,-100,-100,48,null,null,null,null,-54,null,-71,-22,null,null,null,8};
        //Expected ["37->-34->-100","37->-48->-100","37->-48->48->-54->-71","37->-48->48->-54->-22->8"]
        Tree tree=new Tree();
        TreeNode root=tree.buildTree(nums);
        //tree.printTree(root);
        List<String> answer =l257.binaryTreePaths(root);
        System.out.println(answer);
    }
}