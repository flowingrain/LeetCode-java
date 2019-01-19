package LeetCode;

import java.util.HashSet;

public class L202_HappyNumber {
    HashSet<Integer> set=new HashSet<Integer>();
    public boolean isHappy(int n) {
        if(n==1)
            return true;
        set.add(n);
        int res=0;
        while(n>0)
        {
            res+=(n%10)*(n%10);
            n=n/10;
        }
        if(set.contains(res))
            return false;
        return isHappy(res);
    }
    public static void main(String[] args){
        int input=19;
        L202_HappyNumber hn=new L202_HappyNumber();
        System.out.println(hn.isHappy(input));
    }
}