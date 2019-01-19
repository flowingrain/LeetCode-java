package LeetCode;

public class PowerofFour {
    public boolean isPowerOfFour(int n) {
        if(n<=0)
            return false;
        //0x5 0101.
        return ((n&(n-1))==0 && (n&0x55555555)==n);
    }
    public static void main(String[] args){
        PowerofTwo pt=new PowerofTwo();
        System.out.println(pt.isPowerOfTwo(1));
    }
}