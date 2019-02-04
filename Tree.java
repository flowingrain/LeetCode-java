package LeetCode;

import java.util.*;

public class Tree {
    public boolean isPowerSumOf2(int num){
        int pow=0;
        while(num>0){
            num-=Math.pow(2,pow);//Math.pow(a,b)，a的b次方
            pow++;
        }
        if(num==0)
            return true;
        else
            return false;
    }
    public TreeNode makeBinaryTreeByArray(Integer[] array,int index){
        if(index<array.length){
            TreeNode t;
            if(array[index]!=null){//index范围内也可以为null
                t=new TreeNode(array[index]);
                array[index]=0;
                t.left=makeBinaryTreeByArray(array,index*2+1);
                t.right=makeBinaryTreeByArray(array,index*2+2);
                return t;
            }
            else
                return null;
        }else
            return null;
    }
    public TreeNode Tree(Integer[] array){
        return makeBinaryTreeByArray(array,0);
    }
    public TreeNode buildTree(Integer[] array){
        return makeBinaryTreeByArray(array,0);
    }

    public String printStack(LinkedList stack){
        StringBuilder sb=new StringBuilder();
        System.out.println(stack.size()+"***");
        for(int i=0;i<stack.size();i++){
            TreeNode tn=(TreeNode)stack.get(i);
            if(tn!=null)
                sb.append(tn.val+"\t");
        }
        return sb.reverse().toString();
    }

    public String printTree(TreeNode root){
        StringBuilder tree = new StringBuilder();
        List level = new ArrayList();
        List<List<TreeNode>> wholeTree = new ArrayList<List<TreeNode>>();
        level.add(root);
        while(level.size() > 0){
            wholeTree.add(level);
            List newLevel = new ArrayList();
            for (int i = 0; i < level.size(); i++){
                TreeNode node = (TreeNode) level.get(i);//节点可以为空。针对非全二叉树
                if(node!=null){
                    newLevel.add(node.left);
                    newLevel.add(node.right);
                }
            }
            level = newLevel;
        }
        int height = wholeTree.size();
        for (int i = 0; i < height; i++){
            level = wholeTree.get(i);
            int tabNum = (int)(Math.pow(2, height - i - 1) - 1);
            for (int j = 0; j < tabNum; j++){
                tree.append("\t");
            }
            if(level.get(0)!=null)
                tree.append(((TreeNode)level.get(0)).val+"\t") ;
            else
                tree.append("\t");
            tabNum = (int) (Math.pow(2, height - i) - 1);
            for (int j = 1; j < level.size(); j++){
                for (int k = 0; k < tabNum; k++){
                    tree.append("\t");
                }
                if(level.get(j)!=null)
                    tree.append(((TreeNode)level.get(j)).val+"\t");
                else
                    tree.append("\t");
            }
            tree.append("\n");
        }
        System.out.println(tree);
        return tree.toString();
    }

    public void DFS(TreeNode root){
        LinkedList stack=new LinkedList();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=(TreeNode)stack.pop();
            if(node!=null){
                System.out.print(node.val+"\t");
                if(node.left==null&&node.right==null)//叶子节点
                    System.out.println(printStack(stack));
                stack.push(node.right);
                System.out.println(stack.size()+"\\\\");
                stack.push(node.left);
            }
        }
    }
   /* public void printTree(TreeNode root){//输出包含层次结构和相对位置
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
    }*/
    public static void main(String[] args){
        Tree tree=new Tree();
        System.out.println(tree.isPowerSumOf2(4));
    }
}
