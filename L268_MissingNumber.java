package LeetCode;

public class L268_MissingNumber {
    public int missingNumber(int[] nums) {
        int XOR=0,i;
        for(i=0;i<nums.length;i++)
        {
            XOR=XOR^i^nums[i];
        }
        return XOR^i;//前边的i缺n。缺失的数是下标为n对应的数
    }
    public static void main(String[] args){
        L268_MissingNumber l268=new L268_MissingNumber();
        int[] nums={9,6,4,2,3,5,7,0,1};
        System.out.println(l268.missingNumber(nums));
    }
}