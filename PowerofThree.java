package LeetCode;

import static java.lang.Math.log;
import static java.lang.Math.pow;

public class PowerofThree {
    public boolean isPowerOfThree(int n) {
        if(n<0)
            return false;
        return (1162261467 %n==0);
    }
    public static void main(String[] args){
        PowerofThree pt=new PowerofThree();
        System.out.println(pt.isPowerOfThree(9));
    }
}