package LeetCode;

public class L136_SingleNumber {
    public int singleNumber(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            result^=nums[i];//相同数字异或结果为0
        }
        return result;
    }
    public static void main(String[] args){
        L136_SingleNumber l136=new L136_SingleNumber();
        //int[] nums={2,2,1};
        int[] nums={4,1,2,1,2};
        System.out.println(l136.singleNumber(nums));
    }
}
