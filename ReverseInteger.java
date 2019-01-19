package LeetCode;
/*
7
 */
public class ReverseInteger {
    public int reverse(int x) {
        long ans=0;//java中int为32位
        int maxint=0x7fffffff;
        int minint=0x80000000;
/*        int maxint=2147483647;
        int minint=-2147483648;*/
        while(x!=0){
            ans=ans*10+(x%10);
            x=x/10;
        }
        if(ans<minint||ans>maxint){
            ans=0;
        }
        return (int) ans;
    }

    public static void main(String[] args){
        ReverseInteger ri=new ReverseInteger();
        System.out.println(ri.reverse(1534236469 ));
    }
}
