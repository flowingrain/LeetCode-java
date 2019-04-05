package LeetCode;

import java.util.*;

public class L349_IntersectionofTwoArrays {
    /*public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet<>();
        for(int i=0;i<nums1.length;i++)
        {
            set1.add(nums1[i]);
        }
        Set<Integer> set2=new HashSet<>();

        for(int i=0;i<nums2.length;i++)
        {
            set2.add(nums2[i]);
        }
        set1.retainAll(set2);
        Iterator<Integer> it=set1.iterator();
        int[] result=new int[set1.size()];
        int i=0;
        while(it.hasNext()){
            result[i++]=it.next();
        }
        return result;
    }*/
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet<>();
        for(int i=0;i<nums1.length;i++)
        {
            set1.add(nums1[i]);
        }
        Set<Integer> interSet=new HashSet<>();
        for(int i=0;i<nums2.length;i++)
        {
            if(set1.contains(nums2[i]))
                interSet.add(nums2[i]);
        }
        Iterator<Integer> it=interSet.iterator();
        int[] result=new int[interSet.size()];
        int i=0;
        while(it.hasNext()){
            result[i++]=it.next();
        }
        return result;
    }
    public static void main(String[] args){
        L349_IntersectionofTwoArrays l349=new L349_IntersectionofTwoArrays();
        int[] nums1={1,2,2,1};
        int[] nums2={2,2};
        int[] intersection=l349.intersection(nums1,nums2);
        System.out.println(Arrays.toString(intersection));
    }
}