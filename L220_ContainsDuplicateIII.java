package LeetCode;
import java.util.TreeSet;

public class L220_ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k,int t) {
        TreeSet<Long> ts=new TreeSet<Long>();
        for(int i=0;i<nums.length;i++){//建立一个大小为k的集合,把nums[i]和nums[i]的相近值都添加进去
            Long num=(long)nums[i];
            Long floor=ts.floor(num+t);//小于nums[i]+t的最大整数
            Long ceil=ts.ceiling(num-t);//大于nums[i]-t的最小整数
            if((floor!=null&&floor>=num)||(ceil!=null&&ceil<=num))
                return true;
            else
                ts.add(num);
            if(i>=k)
                ts.remove((long)nums[i-k]);
        }
        return false;
    }

    public static void main(String[] args){
        //int[] nums={1,2,3,1};
        //int k=3,t=0;
        //int[] nums={1,0,1,1};
        //int k=1,t=2;
        int[] nums={1,5,9,1,5,9};
        int k=2,t=3;
        L220_ContainsDuplicateIII l220=new L220_ContainsDuplicateIII();
        System.out.println(l220.containsNearbyAlmostDuplicate(nums,k,t));
    }
}
