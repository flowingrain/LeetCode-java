package LeetCode;
/*
231
 */
public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        if(n<=0)
            return false;
        return ((n&(n-1))==0);
    }
    public static void main(String[] args){
        PowerofTwo pt=new PowerofTwo();
        System.out.println(pt.isPowerOfTwo(1));
    }
}
