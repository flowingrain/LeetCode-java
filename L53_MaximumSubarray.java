package LeetCode;
/*
遍历array，对于每一个数字，我们判断，（之前的sum + 这个数字） 和 （这个数字） 比大小，如果（这个数字）自己就比 （之前的sum + 这个数字） 大的话，那么说明不需要再继续加了，直接从这个数字，开始继续，因为它自己已经比之前的sum都大了。
　　　　反过来，如果 （之前的sum + 这个数字）大于 （这个数字）就继续加下去。
 */
public class L53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int len=nums.length;
        int max=-java.lang.Integer.MAX_VALUE;
        if(nums==null||len==0)
            return max=0;
        else if(len==1)
            max=nums[0];
        else{
            int curMax=0;//dp[i]表示到第i个字符的最大字符串和
            for(int i=0;i<len;i++){
                curMax=Math.max(nums[i],curMax+nums[i]);//注意max函数的第一个参数
                if(curMax>max){
                    max=curMax;
                }
            }
        }
        return max;
    }
}