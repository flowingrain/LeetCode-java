package LeetCode;

public class L191_NumberOf1Bits {
    public int hammingWeight(int n) {
        int result=0;
        for(int i=0;i<32;i++){
            if (1==(n&1))
                result++;
            n>>>=1;
        }
        return result;
    }
    public static void main(String[] args){
        L191_NumberOf1Bits l191=new L191_NumberOf1Bits();
        int n=11;
        System.out.println(l191.hammingWeight(n));
    }
}
