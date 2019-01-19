package LeetCode;

public class L287_FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow=nums[0];
        int fast=nums[nums[0]];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        int slow2=0;
        while(slow2!=slow){
            slow=nums[slow];
            slow2=nums[slow2];
        }
        return slow;
    }
    public static void main(String[] args){
        L287_FindTheDuplicateNumber l287=new L287_FindTheDuplicateNumber();
        int[] nums={3,1,3,4,2};
        System.out.println(l287.findDuplicate(nums));
    }
}
