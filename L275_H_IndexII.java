package LeetCode;

public class L275_H_IndexII {
/*    public int hIndex(int[] citations) {//二分查找
        //citations[index] >= length(citations) - index.
        //And return (length - index) as the result.
        int len=citations.length;
        int low=0,high=len-1,mid=0;//mid作为数组的指针，而不是引用数
        while(low<=high) {
            mid = low + (high - low) / 2;
            if (citations[mid]==len-mid) {//比较时，引用数组的起始下标为1
                return len-mid;
            }else if(citations[mid]>len-mid)//len-mid要加，mid要减
                high = mid - 1;//查左半部
            else
                low = mid + 1;//查左半部

        }
        //return len-mid;
        return len-low;//为啥是len-low不是len-mid嘞？此时不存在citations[mid]==len-mid，找citations[index]>lenth(citations)-index的最小index，即最大lenth(citations)-index。左侧咯
    }*/
    /*
    Runtime: 2 ms, faster than 100.00% of Java online submissions for H-Index II.
Memory Usage: 42.7 MB, less than 32.00% of Java online submissions for H-Index II.
     */
    public int hIndex(int[] citations) {
        int len=citations.length;
        int i;
        for(i=0;i<len;i++){
            if(i+1<=citations[len-1-i]) {
                continue;
            }else
                break;
        }
        return i--;
    }
    public static void main(String[] args){
        L275_H_IndexII l275=new L275_H_IndexII();
        //int[]  citations = {3,0,6,1,5};
        //int[]  citations = {0,1,3,5,6};//期望输出，3
        //int[]  citations = {10,8,5,4,3};//期望输出 4
        //int[]  citations = {3,4,5,8,10};
        //int[]  citations = {25,8,5,3,3};//期望输出 3
        int[]  citations = {3,3,5,8,25};//期望输出 3
        //int[]  citations = {100};//期望输出 1
        System.out.println(l275.hIndex(citations));
    }
}
