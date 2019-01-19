package LeetCode;

public class L231_PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n<=0)
            return false;
        return ((n&(n-1))==0);//2的幂次，最高位为1，其余位全为0.与n-1各位都不相同，为0
    }
    public static void main(String[] args){
        L231_PowerOfTwo l231=new L231_PowerOfTwo();
        int num=218;
        System.out.println(l231.isPowerOfTwo(num));
    }
}
