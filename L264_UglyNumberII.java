package LeetCode;

public class L264_UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] ll=new int[n];
        ll[0]=1;
        int index2=0,index3=0,index5=0,temp2=2,temp3=3,temp5=5,last;
        for(int i=1;i<n;i++){//for循环竟然比while快
            last=ll[i-1];
            if(last==temp2)//2 3 5都需要进行判断，存在几个值都相等的情况。不会出现比last小的数，如果有，已经加入数组了
                temp2=2*ll[++index2];
            if(last==temp3)
                temp3=3*ll[++index3];
            if(last==temp5)
                temp5=5*ll[++index5];
            ll[i]=Math.min(temp2,Math.min(temp3,temp5));
        }
        return ll[n-1];
    }
    public static void main(String[] args){
        L264_UglyNumberII l264=new L264_UglyNumberII();
        //int n=10;
        //Input
        //19
        //Output
        //30
        //Expected
        //32
        int n=19;
        System.out.println(l264.nthUglyNumber(n));
    }
}
