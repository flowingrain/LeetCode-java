package LeetCode;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class L257_BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {//解答里每次都加入answer参数是为了保证对同一个链表操作
        List<String> answer= new LinkedList<String>();
        LinkedList stack=new LinkedList();
        LinkedList<TreeNode> dfsOrder=new LinkedList<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=(TreeNode)stack.pop();
            if(node!=null){
                dfsOrder.add(node);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        Iterator<TreeNode> it = dfsOrder.iterator();
        boolean[] isLeaf=new boolean[dfsOrder.size()];//标记节点是否为叶子节点
        while(it.hasNext()){
            TreeNode tn=it.next();//tn一定不为null
            int cur;//当前叶子节点在链表中的位置
            if(tn==null)
                continue;
            else if(tn.left==null&&tn.right==null){//叶子节点
                StringBuilder sb=new StringBuilder();
                cur=dfsOrder.indexOf(tn);//叶子节点的index
                LinkedList<TreeNode> temp=new LinkedList<TreeNode>(dfsOrder);
                isLeaf[cur]=true;
                for(int i=cur-1;i>=0;i--)//从前向后找叶子节点，从后向前找叶子节点的路径
                {
                    if(temp.get(i)==null){
                        continue;
                    } else if(temp.get(i).left==temp.get(cur)||temp.get(i).right==temp.get(cur))//当前节点的父节点
                    {
                        cur=i;
                    }
                    else//不是下一个节点的父节点，不在当前叶子节点的路径上.可能是叶子节点
                    {
                        temp.set(i,null);
                    }
                }
                Iterator<TreeNode> pointer = temp.iterator();
                while(pointer.hasNext()){
                    TreeNode tn1=pointer.next();
                    if(tn1!=null) {
                        if (tn1 != tn) {
                            sb.append(tn1.val+"->");
                        } else{
                            sb.append(tn.val);//打印到叶子节点，后边不打印
                            break;
                        }
                    }
                }
                answer.add(sb.toString());
            }
            else
                continue;
        }
        return answer;
    }
    public static void main(String[] args){
        L257_BinaryTreePaths l257=new L257_BinaryTreePaths();
        Integer[] nums={1,2,3,null,5};
        Tree tree=new Tree();
        TreeNode root=tree.buildTree(nums);
        //tree.printTree(root);
        List<String> answer =l257.binaryTreePaths(root);
        System.out.println(answer);
    }
}