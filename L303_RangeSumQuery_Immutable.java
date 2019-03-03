package LeetCode;

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
public class L303_RangeSumQuery_Immutable {
    //方法1。逐个累加。
   /* private int[] nums;
    public L303_RangeSumQuery_Immutable(int[] nums) {
        this.nums=nums;
    }

    public int sumRange(int i, int j) {
        if(i>j||j>nums.length-1)
            return -1;
        int sum=0;
        for(int index=i;index<=j;index++){
            sum+=nums[index];
        }
        return sum;
    }*/
   //方法2，使用数组记录累加和
    private int[] nums;
    public L303_RangeSumQuery_Immutable(int[] nums) {
        this.nums=nums;
        for(int i=1;i<nums.length;i++){
            nums[i]+=nums[i-1];
            //System.out.println(this.nums[i]);
        }
    }

    public int sumRange(int i, int j) {
        if(i>j||j>nums.length-1)
            return -1;
        if(i==0)
            return nums[j];
        else
            return nums[j]-nums[i-1];//中间的差才是从i~j的和。
    }

    public static void main(String[] args){
        int[] nums={-2, 0, 3, -5, 2, -1};
        L303_RangeSumQuery_Immutable l303=new L303_RangeSumQuery_Immutable(nums);
        System.out.println(l303.sumRange(0,2));
    }
}
