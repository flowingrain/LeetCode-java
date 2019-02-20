package LeetCode;

        import java.util.Arrays;
        import java.util.HashSet;
        import java.util.Iterator;

public class L260_SingleNumberIII {
    /*public int[] singleNumber(int[] nums) {
        if(nums.length<2)
            return nums;
        HashSet<Integer> hs=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(hs.contains(nums[i]))
                hs.remove(nums[i]);
            else
                hs.add(nums[i]);
        }
        Iterator<Integer>  it=hs.iterator();
        int[] result=new int[hs.size()];
        int i=0;
        while(it.hasNext()){
            result[i++]=it.next();
        }
        return result;
    }*/
    public int[] singleNumber(int[] nums) {//运行快，耗内存。
        int diff=0;
        for(int i=0;i<nums.length;i++)
        {
            diff^=nums[i];
        }
       /* System.out.println(Integer.toBinaryString(diff));
        System.out.println(Integer.toBinaryString(-diff));
        System.out.println(Integer.toBinaryString(diff&(-diff)));*/
        diff&=-diff;//此操作下最低的不同位为1，其余位为0.方便将数字分为两组
        int[] result={0,0};
        for(int i=0;i<nums.length;i++)
        {
            if((nums[i]&diff)==0){//不同位上为0的数字
                //System.out.println(Integer.toBinaryString(nums[i]));
                result[0]^=nums[i];
            }else{
                result[1]^=nums[i];//不同位上为1的数字
            }
        }
        return result;
    }
    public static void main(String[] args){
        L260_SingleNumberIII l260=new L260_SingleNumberIII();
        int[] nums={1,2,1,3,2,5};
        System.out.println(Arrays.toString(l260.singleNumber(nums)));
    }
}
