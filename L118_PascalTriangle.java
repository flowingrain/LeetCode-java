package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class L118_PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        if(numRows<0)
            return null;
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();//记录当前层数值
        for(int i=0;i<numRows;i++){
            list.add(1);
            for(int j=i-1;j>0;j--){//一行一行赋值，对每行从右向左赋值，避免修改下一个数字要用到两个加数
                list.set(j,list.get(j-1)+list.get(j));
            }
            result.add(new ArrayList<Integer>(list));
        }
        return result;
    }
    public static void main(String[] args){
        L118_PascalTriangle l118=new L118_PascalTriangle();
        System.out.println(l118.generate(5));
    }
}