package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class L508_MostFrequentSubtreeSum {
    private HashMap<Integer,Integer> hm=new HashMap<Integer, Integer>();//key为sum的值，val为sum的次数
    public int getTreeSum(TreeNode root) {
        int sum=root.val;
        if(root.left!=null)
            sum+=getTreeSum(root.left);
        if(root.right!=null)
            sum+=getTreeSum(root.right);
        if(!hm.containsKey(sum))
            hm.put(sum,1);
        else
            hm.put(sum,hm.get(sum)+1);//put的方法即是添加也是修改
        return sum;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root==null)
            return new int[0];
        LinkedList<Integer> ll=new LinkedList<Integer>();
        getTreeSum(root);
        //获取最大值
        int max=Integer.MIN_VALUE;
        int count=0;//最大值出现的次数
        for(int val:hm.values()) {
            if(val>max) {
                max = val;
                count=1;
            }else if(val==max){
                count++;
            }
        }
        int[] result=new int[count];//记录最大值对应的子树和
        int index=0;//数组下标
        for(Map.Entry<Integer, Integer> entry: hm.entrySet()) {
            if(entry.getValue()==max)
                result[index++]=entry.getKey();
        }
        return result;
    }
    public static void main(String[] args){
        //Integer[] nodeVals={5,2,-3};
        Integer[] nodeVals={5,2,-5};
        Tree tree=new Tree();
        TreeNode root=tree.buildTree(nodeVals);
        L508_MostFrequentSubtreeSum l508=new L508_MostFrequentSubtreeSum();
        System.out.println(Arrays.toString(l508.findFrequentTreeSum(root)));
    }
}