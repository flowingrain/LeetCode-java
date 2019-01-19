package LeetCode;

public class L172_FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        long factor=5;
        int res=0;
        while(n/factor>0){//n不变，除数不断增大
            //n=n/factor;
            res+=n/factor;
            factor*=5;//5的幂,如25，含有多个5
        }
        return res;
    }
    public static void main(String[] args){
        L172_FactorialTrailingZeroes l172=new L172_FactorialTrailingZeroes();
        System.out.println(l172.trailingZeroes(30));
    }
}