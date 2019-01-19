package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class L217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        if(nums.length<=1)
            return false;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]==nums[i+1])
                return true;
        }
        return false;
    }
    public static void main(String[] args){

    }
}
