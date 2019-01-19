package LeetCode;

public class L189_RotateArray {
    // Reverse the first n - k elements,
    // the last k elements, and then all the n elements.
    public void rotate(int[] nums, int k) {
        int len=nums.length;
        k=k%len;
        int temp=0;
        for(int i=0;i<(len-k)/2;i++){
            temp=nums[i];
            nums[i]=nums[len-k-1-i];
            nums[len-k-1-i]=temp;
        }
        for(int i=0;i<k/2;i++){
            temp=nums[len-k+i];//前半段下标0~len-k-1;后半段len-k~len-1
            nums[len-k+i]=nums[len-1-i];
            nums[len-1-i]=temp;
        }
        for(int i=0;i<len/2;i++){
            temp=nums[i];
            nums[i]=nums[len-1-i];
            nums[len-1-i]=temp;
        }
    }

    public static void main(String[] args){
        int[] nums={1,2,3,4,5,6,7};
        L189_RotateArray l189=new L189_RotateArray();
        l189.rotate(nums,3);
        for (int num:nums) {
            System.out.print(num+"\t");
        }
    }
}