package LeetCode;

public class L35_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int pos=0;
        int len=nums.length;
        if(len==0)
            return pos;
        else if(len==1){
            if(nums[0]>=target)
                pos=0;
            else
                pos=1;
        }else{
            for(int i=0;i<len;i++)
            {
                if(nums[i]<target)
                    pos++;
                else
                    break;
            }
        }
        return pos;
    }
}