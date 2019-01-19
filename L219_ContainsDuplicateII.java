package LeetCode;

import java.util.HashSet;

public class L219_ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet hm=new HashSet();
        for(int i=0;i<nums.length&&i<k;i++){//建立一个大小为k的集合
            if(hm.contains(nums[i]))
                return true;
            else
                hm.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++){//集合作为滑动窗口，比较是否有距离小于k的相同的两个值
            if(hm.contains(nums[i]))
                return true;
            else
            {
                hm.add(nums[i]);
                hm.remove(nums[i-k]);
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums={1,2,3,1,2,3};
        L219_ContainsDuplicateII l219=new L219_ContainsDuplicateII();
        System.out.println(l219.containsNearbyDuplicate(nums,2));
    }
}
