package LeetCode;

public class L274_H_Index {
   /* public int hIndex(int[] citations) {//citations中的下标是从1开始算的，实际存储是从0开始的。
        int len=citations.length;
        if(len==0)
            return 0;
        Arrays.sort(citations);
        int hIndex=0;
        for(int i=0;i<len;i++){
            int temp=Math.min(citations[len-1-i],i+1);
            if(hIndex<temp)
                hIndex=temp;
            else
                break;//后边的i会越来越小，没必要接着算
        }
        return hIndex;
    }*/
   //https://leetcode.com/problems/h-index/discuss/70768/Java-bucket-sort-O(n)-solution-with-detail-explanation
   public int hIndex(int[] citations) {//citations中的下标是从1开始算的，实际存储是从0开始的。
       int n=citations.length;
       int hindex=0;
       int[] buckets=new int[n+1];
       for(int i=0;i<n;i++)
       {
           if(citations[i]>=n){//存储引用大于等于n的文章数
               buckets[n]++;
           }
           else
               buckets[citations[i]]++;//存储引用为citations[i]的文章数
       }
       int sum=0;
       for(int i=n;i>=0;i--){
           sum+=buckets[i];//引用数大于等于i的文章数
           //System.out.println(i);
           if(sum>=i)//引用数大于文章数的最大值。
           {
               hindex=i;
               break;
           }
       }
       return  hindex;
   }
    public static void main(String[] args){
        L274_H_Index l274=new L274_H_Index();
        //int[]  citations = {3,0,6,1,5};
        int[]  citations = {10,8,5,4,3};//期望输出 4
        //int[]  citations = {25,8,5,3,3};//期望输出 3
        //int[]  citations = {100};//期望输出 1
        System.out.println(l274.hIndex(citations));
    }
}
