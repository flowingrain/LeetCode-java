package LeetCode;

public class L27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        /*
        返回移除val后的数组长度
        同时需要对nums进行修改，使得nums前len个数不包含val值
        前len个数的顺序不做要求
        考虑类似快排的交换方式
         */
        int len=nums.length;
        int start=0,end=len-1;
        while(end>=start){
            //从后往前比较
            while(end>=start&&nums[end]==val)  //如果当前值等于val，比较下一个，直到有不等于val的交换位置，然后又从前往后比较
            {
                end--;
                len--;
            }
            //从前往后比较
            while(end>=start&&nums[start]!=val)//如果没有等于val的，比较下一个，直到有比等于val的交换位置
                start++;
            if(end>=start){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
            //一次循环交换一对数值的位置
        }
        // 比较结束，nums即基本有序。左边的值都不等于val，右边的值等于val
        return len;
    }
    public static void main(String[] args){
        int[] nums={1};
        int val=1;
        L27_RemoveElement re=new L27_RemoveElement();
        int len = re.removeElement(nums, val);
        // any modification to nums in your function would be known by the caller.
        // using the length returned by your function, it prints the first len elements.
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}