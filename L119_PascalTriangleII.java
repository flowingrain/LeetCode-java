package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class L119_PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex<0)
            return null;
        //从0开始的第k行，即（k+1）对应斐波那契数列的最后一行
        int listLen=rowIndex+1;
        List<Integer> list=new ArrayList<Integer>();//记录当前层数值
        for(int i=0;i<listLen;i++)//不知道为什么这句写在这里比下边二层循环的外层快，
            list.add(1);//整个都赋1，初试值，各层边界值
        for(int i=0;i<listLen;i++){
            for(int j=i-1;j>0;j--){//一行一行赋值，对每行从右向左赋值，避免修改下一个数字要用到两个加数
                list.set(j,list.get(j-1)+list.get(j));
            }
        }
        return list;
    }
    public static void main(String[] args){
        long time1=System.currentTimeMillis();
        L119_PascalTriangleII l119=new L119_PascalTriangleII();
        System.out.println(l119.getRow(25));//从0开始的第k行，即（k+1）对应斐波那契数列的最后一行
        long time2=System.currentTimeMillis();
        long intervals=time2-time1;
        System.out.println(intervals);
    }
}
