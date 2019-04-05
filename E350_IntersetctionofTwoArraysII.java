package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//E for easy
public class E350_IntersetctionofTwoArraysII {
    /*public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1=nums1.length;
        int len2=nums2.length;
        List<Integer> resultList=new ArrayList<>();
        for(int i=0,j=0;i<len1&&j<len2;){
            if(nums1[i]==nums2[j])
            {
                resultList.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i]<nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        int[] result=new int[resultList.size()];
        Iterator<Integer> it=resultList.iterator();
        int i=0;
        while(it.hasNext()){
            result[i++]=it.next();
        }
        return result;
    }*/
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1=nums1.length;
        int len2=nums2.length;
        int[] result=new int[Math.min(len1,len2)];
        int count=0;
        for(int i=0,j=0;i<len1&&j<len2;){
            if(nums1[i]==nums2[j])
            {
                result[count++]=nums1[i];
                i++;
                j++;
            }else if(nums1[i]<nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        return Arrays.copyOf(result,count--);//返回数组不借助链表
    }
    public static void main(String[] args){
        E350_IntersetctionofTwoArraysII e350=new E350_IntersetctionofTwoArraysII();
        int[] nums1={1,2,2,1};
        int[] nums2={2,2};
        int[] intersection=e350.intersect(nums1,nums2);
        System.out.println(Arrays.toString(intersection));
    }
}
