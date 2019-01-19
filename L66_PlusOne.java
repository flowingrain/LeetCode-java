package LeetCode;

public class L66_PlusOne {
    public int[] plusOne(int[] digits) {
        int len=digits.length;
        int[] result=new int[len+1];
        /*for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
        System.out.println(result);*/
        int carry=1;//加1
        for(int i=len-1;i>=0;i--){//数组最高位表示数字低位，从最高位开始算
            digits[i]+=carry;
            if(digits[i]==10){
                digits[i]=0;
                carry=1;//向前进位
            }else
                carry=0;
        }
        if(carry==1){
            result[0]=carry;
            for(int i=0;i<len;i++){
                result[i+1]=digits[i];
            }
            return result;
        }else
            return digits;
    }
    public static  void main(String[] args){
        L66_PlusOne l66=new L66_PlusOne();
        int[] digits={9,8,7,6,5,4,3,2,1,0};
        int[] result=l66.plusOne(digits);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]);
        }
    }
}