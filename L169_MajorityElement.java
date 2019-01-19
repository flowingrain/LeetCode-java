package LeetCode;

import java.util.Arrays;
import java.util.Stack;

public class L169_MajorityElement {
    /*
    //34ms
    public int majorityElement(int[] nums) {
        Stack<Integer> stack=new Stack<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(stack.isEmpty()||stack.peek()==nums[i])
                stack.push(nums[i]);
            else
                stack.pop();
        }
        return stack.peek();
    }*/
   /*
   //5ms
   public int majorityElement(int[] nums) {
        int count=0,result=0;
        for(int i=0;i<nums.length;i++)
        {
            if(count==0)
                result=nums[i];
            if(result==nums[i])
                count++;
            else
                count--;
        }
        return result;
    }*/
   //3ms
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    public static void main(String[] args){
        L169_MajorityElement l169=new L169_MajorityElement();
        //int[] nums={3,2,3};
        int[] nums={2,2,1,1,1,2,2};
        System.out.println(l169.majorityElement(nums));
    }
}