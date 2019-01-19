package LeetCode;

public class L88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len=m+n;
        int count=0;//从后往前按顺序插入，已确定位置数字数目
        int i=0,j=0;//i j分别为数组nums1 nums2上的游标
        while(i<m&&j<n){
            if(nums1[m-1-i]>=nums2[n-1-j]){
                nums1[len-1-count]=nums1[m-1-i];
                i++;
                count++;
            }
            else{
                nums1[len-1-count]=nums2[n-1-j];
                j++;
                count++;
            }
        }
        if(i<m){
            for(;i<m;i++){
                nums1[len-1-count]=nums1[m-1-i];
                count++;
            }
        }else if(j<n){
            for(;j<n;j++){
                nums1[len-1-count]=nums2[n-1-j];
                count++;
            }
        }
    }
    public static void main(String[] args){
        int[] nums1=new int[6];//[1,2,3,0,0,0]
        int[] nums2=new int[3];//[2,5,6]
        nums1[0]=1;
        nums1[1]=2;
        nums1[2]=3;
        //nums2[0]=2;
        nums2[0]=4;
        nums2[1]=5;
        nums2[2]=6;
        L88_MergeSortedArray l88=new L88_MergeSortedArray();
        l88.merge(nums1,3,nums2,3);
        for(int i=0;i<nums1.length;i++){
            System.out.print(nums1[i]+"\t");
        }
    }
}