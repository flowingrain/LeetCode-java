package LeetCode;
/*
蛮力，Runtime: 63 ms, faster than 6.02% of Java online submissions for Sqrt(x).
 */
public class L69_SqrtX {
    /*public int mySqrt(int x) {
        int res=0;
        int curSquare=0;//记录上一轮平方数，
        int nextSquare=0;
        for(int i=0;i<=x/2;i++)
        {
            nextSquare=(i+1)*(i+1);
            if(nextSquare>x||nextSquare<curSquare)//如果平方溢出，一定是大于x的
                break;
            else{
                res++;
                curSquare=nextSquare;
            }
        }
        return res;
    }*/

    /*
    牛顿法
     */

    public int mySqrt (int x) {
        if (x <= 1)
            return x;
        double assume = x / 2;
        while (Math.abs(Math.pow(assume, 2) - x) >=1) {
            assume = (assume + x/assume) / 2;//求当前值与除以x的结果的均值，故能不断接近平方根
        }
        return (int) Math.floor(assume);
    }
    /*//二分查找
    public int mySqrt (int x) {
        if (x <= 1)
            return x;
        int left=1,right=Integer.MAX_VALUE;
        int res=0;
        while(left<right){
            res=left+(right-left)/2;//防止溢出
            if(res>x/res){
                right=res;
            }else{
                left=res;
            }
            if(right-left<=1)
                break;
        }
        return (left+right)/2;
    }*/
    public static void main(String[] args){
        L69_SqrtX l69=new L69_SqrtX();
        System.out.println(l69.mySqrt(2147395600));
    }
}