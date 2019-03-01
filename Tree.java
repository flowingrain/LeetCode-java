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
    /*public TreeNode makeBinaryTreeByArray(Integer[] array,int index){
        //对{1,null,2,3}不可行。根节点左子树空，第三行就不能再加几个null
        if(index<array.length){
            TreeNode t;
            if(array[index]!=null){//index范围内也可以为null
                t=new TreeNode(array[index]);
                array[index]=0;
                t.left=makeBinaryTreeByArray(array,index*2+1);//对全二叉树成立
                t.right=makeBinaryTreeByArray(array,index*2+2);
                return t;
            }
            else
                return null;
        }else
            return null;
    }*/

    public TreeNode buildTree(Integer[] array){
        TreeNode root=new TreeNode(array[0]);//假设array[0]不为null
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        /*
        add        增加一个元索                     如果队列已满，则抛出一个IIIegaISlabEepeplian异常
        remove   移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
        element  返回队列头部的元素             如果队列为空，则抛出一个NoSuchElementException异常
        offer       添加一个元素并返回true       如果队列已满，则返回false
        poll         移除并返问队列头部的元素    如果队列为空，则返回null
        peek       返回队列头部的元素             如果队列为空，则返回null
        put         添加一个元素                      如果队列满，则阻塞
        take        移除并返回队列头部的元素     如果队列为空，则阻塞
         */
        queue.offer(root);
        int count=0,len=array.length;
        //System.out.println(len);
        while(!queue.isEmpty()){
            TreeNode temp=queue.poll();
            if(temp!=null){
                if(count+1<len){
                    if(array[count+1]==null)//如果TreeNode的构造函数接收的参数为Integer，则可以省去此处if else
                        temp.left=null;
                    else
                        temp.left=new TreeNode(array[count+1]);
                    count++;
                    queue.offer(temp.left);
                }
                if(count+1<len) {
                    if(array[count+1]==null)
                        temp.right=null;
                    else
                        temp.right = new TreeNode(array[count+1]);
                    count++;
                    queue.offer(temp.right);
                }
            }
        }
        return root;
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

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int depth=1;
        depth+=Math.max(maxDepth(root.left),maxDepth(root.right));
        return depth;
    }

    public void printTree(TreeNode root){
        int depth=maxDepth(root);
        //然后就是层次遍历，在打印每一层的节点之前和之后打印tab。子节点的位置根据父节点的位置计算。
        if(root==null)
            return;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();

        HashMap<TreeNode,Integer> posMap=new HashMap<TreeNode, Integer>();//记录节点位置。
        queue.offer(root);
        int level=1,levelCount=1,nextlevelCount=0;//记录当前层号及层节点数
        posMap.put(root,(int)Math.pow(2,depth-level));
        while(!queue.isEmpty()){
            TreeNode temp=queue.poll();
            for(int i=0;i<posMap.get(temp);i++)
                System.out.print("\t");
            System.out.print(temp.val);

            if(temp.left!=null){
                nextlevelCount++;
                posMap.put(temp.left,posMap.get(temp)-(int)Math.pow(2,depth-(level+1)));
                queue.offer(temp.left);

            }
            if(temp.right!=null){
                nextlevelCount++;
                posMap.put(temp.right,posMap.get(temp)+(int)Math.pow(2,depth-(level+1)));
                queue.offer(temp.right);
            }
            levelCount--;
            if (levelCount==0)//开始打印下一层
            {
                levelCount=nextlevelCount;
                level++;
                nextlevelCount=0;
                System.out.println();
            }
        }
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
