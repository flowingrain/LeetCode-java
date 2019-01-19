package LeetCode;

public class L198_HouseRobber {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len==0)
            return 0;
        int prev1 = nums[0], prev2=0, temp;
        for (int i = 1; i < len; i++) {
            temp = prev1;
            prev1 = Math.max(prev2 + nums[i], prev1);
            prev2 = temp;
        }
        return prev1;
    }
    public static void main(String[] args){
        int[] input={1,2,3,1};
        L198_HouseRobber hr=new L198_HouseRobber();
        System.out.println(hr.rob(input));
    }
}