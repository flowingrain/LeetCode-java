package LeetCode;

public class L75_SortColors {
    public void swap(int[] nums,int i,int j){//i j相等就不交换
        if(i!=j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
    }
    public void printArray(int[] nums){
        for(int i=0;i<nums.length;i++)
            System.out.print(nums[i]+"\t");
    }
    public void sortColors(int[] nums) {
        int j=0,k=nums.length-1;//j为0的最大下标，k为2的最小下标
        for(int i=0;i<=k;i++){
/*            System.out.println(":"+i);
            printArray(nums);
            System.out.println();*/
            if(nums[i]==0){
                swap(nums,i,j);
                j++;
                //i--;
            }else if(nums[i]==2) {//交换后，重新判定当前位置的值.前边一定没有2（原本有的话，已经和后边交换过了），但后边却可能有0
                swap(nums, i, k);
                k--;
                //i--;
            }
        }
    }
    public static void main(String[] args){
        //int[] nums={2,0,2,1,1,0};
        int[] nums={2,0,1};
        //int[] nums={1,2,0};
        L75_SortColors l75=new L75_SortColors();
        l75.sortColors(nums);
        for(int i=0;i<nums.length;i++)
        {
            System.out.print(nums[i]+"\t");
        }
    }
}