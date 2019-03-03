package LeetCode;

/*
https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation
tails is an array storing the smallest tail of all increasing subsequences with length i+1 in tails[i].
For example, say we have nums = [4,5,6,3], then all the available increasing subsequences are:

len = 1   :      [4], [5], [6], [3]   => tails[0] = 3
len = 2   :      [4, 5], [5, 6]       => tails[1] = 5
len = 3   :      [4, 5, 6]            => tails[2] = 6

We can easily prove that tails is a increasing array. Therefore it is possible to do a binary search in tails array to find the one needs update.

Each time we only do one of the two:

(1) if x is larger than all tails, append it, increase the size by 1
(2) if tails[i-1] < x <= tails[i], update tails[i]

 */
public class L300_LongestIncresingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums.length<1)
            return 0;
        int[] tails=new int[nums.length+1];
        tails[0]=nums[0];
        int len=1;

        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<tails[0])
                tails[0]=nums[i];
            if(nums[i]>tails[len-1]){
                tails[++len-1]=nums[i];
            }else{
                for(int j=0;j<len-1;j++){
                    if(nums[i]>tails[j]&&nums[i]<tails[j+1]){
                        tails[j+1]=nums[i];
                    }
                }
            }
            /*for(int j=0;j<len;j++){
                System.out.print(tails[j]+"\t");
            }
            System.out.println();*/
        }
        return len;
    }
    public static void main(String[] args){
        L300_LongestIncresingSubsequence l300=new L300_LongestIncresingSubsequence();
        int[] nums={10,9,2,5,3,7,101,18};
        System.out.println(l300.lengthOfLIS(nums));
    }
}
