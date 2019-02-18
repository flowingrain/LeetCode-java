package LeetCode;

public class L263_UglyNumber {
    public boolean isUgly(int num) {
        if(num<1)
            return false;
        while(num>1){
            if(num%2==0)
                num/=2;
            else if(num%3==0)
                num/=3;
            else if(num%5==0)
                num/=5;
            else
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        L263_UglyNumber l263=new L263_UglyNumber();
        int num=14;
        System.out.println(l263.isUgly(num));
    }
}